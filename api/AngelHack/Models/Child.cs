using System;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;


namespace AngelHack.Models
{
    [Table("Child")]
    public class Child
    {
        [Key]
        public string ChildID { get; set; }
        public string ChildName { get; set; }
        public string ParentName { get; set; }
        public DateTime DateOfBirth { get; set; }
        public int OfficerID { get; set; }
        public string ParentNumber { get; set; }
        public string EmergencyNumber { get; set; }
        
        [ForeignKey("OfficerID")]
        public Officer Officer { get; set; }

    }
}