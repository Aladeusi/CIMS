using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using System.Linq;
using System.Web;

namespace AngelHack.Models
{
    [Table("Parent")]
    public class Parent
    {
        [Key]
        public int ParentID { get; set; }
        public string PhoneNumber { get; set; }
        public string EmergencyNo { get; set; }
        public string EmailAddress { get; set; }
    }
}