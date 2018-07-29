using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using System.Linq;
using System.Web;

namespace AngelHack.Models
{
    [Table("Facility")]
    public class Facility
    {
        [Key]
        public int FacilityID { get; set;}
        public string Name { get; set; }
        public string Address { get; set; }
        public string State { get; set; }
        public string EmailAddress { get; set; }
    }
}