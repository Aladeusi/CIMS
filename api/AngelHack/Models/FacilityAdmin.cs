using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using System.Linq;
using System.Web;

namespace AngelHack.Models
{
    [Table("FacilityAdmiin")]
    public class FacilityAdmin
    {
        [Key]
        public int FacilityAdminID { get; set; }
        public int FacilityID { get; set; }
        public string Password { get; set; }
        public string EmailAddress { get; set; }

        [ForeignKey("FacilityID")]
        public Facility Facility { get; set; }
    }
}