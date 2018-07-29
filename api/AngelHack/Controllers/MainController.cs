using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Http;
using AngelHack.Models;

namespace AngelHack.Controllers
{
    public class MainController : ApiController
    {
        private Context context = new Context();

        //register parent
        [HttpPost]
        [Route("api/parent/register")]
        public IHttpActionResult RegisterParent(Parent parentModel)
        {
            if (!ModelState.IsValid)
                return BadRequest("Invalid data.");

            context.Parent.Add(new Parent()
            {
                ParentID = parentModel.ParentID,
                EmergencyNo = parentModel.EmergencyNo,
                PhoneNumber = parentModel.PhoneNumber
            });

            context.SaveChanges();

            return Ok();
        }

        //register child
        [HttpPost]
        [Route("api/child/register")]
        public IHttpActionResult RegisterChild(Child childModel)
        {
            if (!ModelState.IsValid)
                return BadRequest("Invalid data.");

            context.Child.Add(new Child() {
                ChildID = childModel.ChildID,
                OfficerID = childModel.OfficerID,
                DateOfBirth = childModel.DateOfBirth,
                EmergencyNumber = childModel.EmergencyNumber,
                ParentName = childModel.ParentName,
                ChildName = childModel.ChildName,
                ParentNumber = childModel.ParentNumber
            });
            context.SaveChanges();
            return Ok();
        }

        [HttpGet]
        [Route("api/children")]
        public IHttpActionResult GetChildren(string ParentNumber)
        {
            var data = context.Child.Where(x => x.ParentNumber == ParentNumber);
            return Ok(data);
        }

        
        [HttpGet]
        [Route("api/child/record")]
        public IHttpActionResult GetChildRecord(string ChildID)
        {
            
            var data = (from record in context.Immunization
                         join child in context.Child on record.ChildID equals child.ChildID
                         join week in context.Week on record.WeekID equals week.WeekID
                         where record.ChildID == ChildID
                         select new
                         {
                             Name = child.ChildName,
                             ChildID = child.ChildID,
                             ImmunizationStage = week.Weeks
                         });
            return Ok(data);
        }
        //[HttpGet]
        //[Route("api/child")]
        //public IHttpActionResult GetChild(string ChildID)
        //{
        //    //var data = context.Child.Where(x => x.Ctc.Equals(Ctc));
        //    var data_ = (from child in context.Child
        //                 join vaccinated in context.Vaccinated on child.ChildID equals vaccinated.ChildID
        //                 join vaccine in context.Vaccine on vaccinated.VaccineID equals vaccine.VaccineID
        //                 join week in context.Week on vaccine.WeekID equals week.WeekID
        //                 where child.ChildID == ChildID
        //                 select new {
        //                     Name = child.Name,
        //                     ChildID = child.ChildID,
        //                     Vaccine = vaccine.Name
        //                 });
        //    return Ok(data_);
        //}

        //[HttpPost]
        //[Route("api/immunization/administer")]
        //public IHttpActionResult Administer(Vaccinated vaccinated)
        //{
        //    if (!ModelState.IsValid)
        //        return BadRequest("Invalid data.");

        //    context.Vaccinated.Add(new Vaccinated()
        //    {
        //        VaccineID = vaccinated.VaccineID,
        //        ChildID = vaccinated.ChildID,
        //        Date = DateTime.Today,
        //        VaccinatedID = vaccinated.VaccinatedID,
                
        //    });
        //    context.SaveChanges();

        //    return Ok();
        //}

        [HttpPost]
        [Route("api/immunization/administer")]
        public IHttpActionResult Administer(Immunization immunize)
        {
            if (!ModelState.IsValid)
                return BadRequest("Invalid data.");

            context.Immunization.Add(new Immunization()
            {
                ID = immunize.ID,
                ChildID = immunize.ChildID,
                WeekID = immunize.WeekID
            });
            context.SaveChanges();

            return Ok();
        }


        [HttpGet]
        [Route("api/vaccine")]
        public IHttpActionResult GetAllVaccines()
        {
            //var data
            return Ok();
        }
    }
}