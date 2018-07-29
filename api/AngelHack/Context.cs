using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Linq;
using System.Web;
using AngelHack.Models;

namespace AngelHack
{
    public class Context : DbContext
    {
        public Context() : base("name=AngelHackConnectionString")
        {
            Database.SetInitializer<Context>(new DropCreateDatabaseIfModelChanges<Context>());
        }

        public DbSet<Child> Child { get; set; }
        public DbSet<Facility> Facility { get; set; }
        public DbSet<FacilityAdmin> FacilityAdmin { get; set; }
        public DbSet<Officer> Officer { get; set; }
        public DbSet<Parent> Parent { get; set; }
        public DbSet<Vaccinated> Vaccinated { get; set; }
        public DbSet<Vaccine> Vaccine { get; set; }
        public DbSet<Week> Week { get; set; }
        public DbSet<Immunization> Immunization { get; set; }
    }
}