using System;
using System.Collections.Generic;
using System.Data.SqlClient;
using System.Linq;
using System.Web;
using System.Web.Http;
using AngelHack.Models;

namespace AngelHack.Controllers
{
    public class FacilityController : ApiController
    {
        private Context context = new Context();

        [HttpPost]
        [Route("api/facility/register")]
        public IHttpActionResult PostNewFacility(Facility facilityModel)
        {
            if (!ModelState.IsValid)
                return BadRequest("Invalid data.");

            context.Facility.Add(new Facility()
            {
                FacilityID = facilityModel.FacilityID,
                Address = facilityModel.Address,
                EmailAddress = facilityModel.EmailAddress,
                Name = facilityModel.Name,
                State = facilityModel.State
            });

            context.SaveChanges();
            return Ok();
        }

        [HttpGet]
        [Route("api/facility")]
        public IHttpActionResult GetFacility(int FacilityID)
        {
            var data = context.Facility.Where(x => x.FacilityID == FacilityID);
            return Ok(data);
        }

        [HttpPost] 
        [Route("api/officer/register")]
        public IHttpActionResult PostNewOfficer(Officer officerModel)
        {
            if (!ModelState.IsValid)
                return BadRequest("Invalid data.");

            context.Officer.Add(new Officer()
            {
                OfficerID = officerModel.OfficerID,
                EmailAddress = officerModel.EmailAddress,
                FacilityID = officerModel.FacilityID,
                Password = officerModel.Password
            });

            context.SaveChanges();
            return Ok();
        }

        [HttpGet]
        [Route("api/facility/children")]
        public IHttpActionResult GetFacilityChildren(int facilityID)
        {
            
            var data = (from child in context.Child
             join officer in context.Officer on child.OfficerID equals officer.OfficerID
             join facility in context.Facility on officer.FacilityID equals facility.FacilityID
             join immunization in context.Immunization on child.ChildID equals immunization.ChildID
             where facility.FacilityID == facilityID
             select new {
                 Name = child.ChildName,
                 DOB = child.DateOfBirth,
                 ParentName = child.ParentName,
                 ParentNumber = child.ParentNumber,
                 EmergencyNumber = child.EmergencyNumber,
                 ChildID = child.ChildID
             }).ToList();

            var data_ = context.Database.SqlQuery<ChildrenResult>("select CH.ChildName as Name, " +
                "CH.DateOfBirth as DOB,CH.ParentName as ParentName, CH.ParentNumber as ParentNumber," +
                " CH.EmergencyNumber as EmergencyNumber, CH.ChildID as ChildID from Child as CH inner " +
                "join Office as OFI on CH.OfficerID = OFI.OfficerID inner join Facility as FA on OFI.FacilityID = " +
                "FA.FacilityID where FA.FacilityID = @FacilityID", 
                new SqlParameter("FacilityID", facilityID));
            return Ok(data_);
        }

        
        public class ChildrenResult
        {
            public string Name { get; set; }
            public DateTime DOB { get; set; }
            public string ParentName { get; set; }
            public string ParentNumber { get; set; }
            public string EmergencyNumber { get; set; }
            public string ChildID { get; set; }
        }

    }
}