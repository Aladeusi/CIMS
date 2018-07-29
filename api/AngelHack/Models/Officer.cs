using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using System.Linq;
using System.Web;

namespace AngelHack.Models
{
    [Table("Office")]
    public class Officer
    {
        [Key]
        public int OfficerID {get; set;}
        public int FacilityID { get; set; }
        public string EmailAddress { get; set; }
        public string Password { get; set; }

        [ForeignKey("FacilityID")]
        public Facility Facility { get; set; }
    }
}