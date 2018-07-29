using Microsoft.Owin.Security;
using Microsoft.Owin.Security.OAuth;
using System.Collections.Generic;
using System.Linq;
using System.Security.Claims;
using System.Threading.Tasks;

using Microsoft.Owin.Security.Infrastructure;
using System.Collections.Concurrent;
using System;
using AngelHack.Models;
using System.Web.Http.Cors;

namespace AngelHack
{
    [EnableCors(origins: "*", headers: "*", methods: "*")]
    public class SimpleAuthorizationServerProvider : OAuthAuthorizationServerProvider
    {
        private bool HasChangedPassword;
        public override async Task ValidateClientAuthentication(OAuthValidateClientAuthenticationContext context)
        {
            context.Validated(); //   
        }

        public override async Task GrantResourceOwnerCredentials(OAuthGrantResourceOwnerCredentialsContext context)
        {
            var identity = new ClaimsIdentity(context.Options.AuthenticationType);
            context.OwinContext.Response.Headers.Add("Access-Control-Allow-Origin", new[] { "*" });

            Context db = new Context();


            var n = db.Officer.Where(u => u.EmailAddress == context.UserName && u.Password == context.Password).FirstOrDefault<Officer>();
            if (!string.IsNullOrEmpty(n.EmailAddress))
            {
                
                identity.AddClaim(new Claim("Age", "16"));

                var props = new AuthenticationProperties(new Dictionary<string, string>
                            {
                                {
                                    "userdisplayname", context.UserName
                                },
                                {
                                     "role", "admin"
                                }
                             });

                var ticket = new AuthenticationTicket(identity, props);
                context.Validated(ticket);
            }
            else
            {
                context.SetError("invalid_grant", "Provided username and password is incorrect");
                context.Rejected();
            }
            //}

            //else
            //{
            //    context.SetError("invalid_grant", "Provided username and password is incorrect");
            //    context.Rejected();
            //}
            return;


        }

        public override async Task TokenEndpoint(OAuthTokenEndpointContext context)
        {
            context.AdditionalResponseParameters.Add("hasChangedPassword", HasChangedPassword.ToString());

            return;
        }

    }

    public class RefreshTokenProvider : IAuthenticationTokenProvider
    {
        private static ConcurrentDictionary<string, AuthenticationTicket> _refreshTokens = new ConcurrentDictionary<string, AuthenticationTicket>();

        public async Task CreateAsync(AuthenticationTokenCreateContext context)
        {

            var guid = Guid.NewGuid().ToString();

            // copy all properties and set the desired lifetime of refresh token  
            var refreshTokenProperties = new AuthenticationProperties(context.Ticket.Properties.Dictionary)
            {
                IssuedUtc = context.Ticket.Properties.IssuedUtc,
                ExpiresUtc = DateTime.UtcNow.AddMinutes(60)
            };

            var refreshTokenTicket = new AuthenticationTicket(context.Ticket.Identity, refreshTokenProperties);

            _refreshTokens.TryAdd(guid, refreshTokenTicket);

            // consider storing only the hash of the handle  
            context.SetToken(guid);
        }


        public void Create(AuthenticationTokenCreateContext context)
        {
            throw new NotImplementedException();
        }

        public void Receive(AuthenticationTokenReceiveContext context)
        {
            throw new NotImplementedException();
        }

        public async Task ReceiveAsync(AuthenticationTokenReceiveContext context)
        {
            // context.DeserializeTicket(context.Token);
            AuthenticationTicket ticket;
            string header = context.OwinContext.Request.Headers["Authorization"];

            if (_refreshTokens.TryRemove(context.Token, out ticket))
            {
                context.SetTicket(ticket);
            }
        }
    }
}