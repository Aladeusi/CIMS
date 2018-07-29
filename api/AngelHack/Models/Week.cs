using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using System.Linq;
using System.Web;

namespace AngelHack.Models
{
    [Table("Week")]
    public class Week
    {
        [Key]
        public int WeekID { get; set; }
        public int Weeks { get; set; }
    }
}