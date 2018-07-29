using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using System.Linq;
using System.Web;

namespace AngelHack.Models
{
    [Table("Vaccine")]
    public class Vaccine
    {
        [Key]
        public int VaccineID { get; set; }
        public string Name { get; set; }
        public string Disease { get; set; }
        public int WeekID { get; set; }

        [ForeignKey("WeekID")]
        public Week Week { get; set; }
    }
}