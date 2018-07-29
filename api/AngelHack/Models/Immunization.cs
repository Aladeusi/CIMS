using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations.Schema;
using System.Linq;
using System.Web;

namespace AngelHack.Models
{
    [Table("Immunization")]
    public class Immunization
    {
        public int ID { get; set; }
        public int WeekID { get; set; }
        public string ChildID { get; set; }

        [ForeignKey("WeekID")]
        public Week Week { get; set; }
    }
}