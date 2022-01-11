package vishal_palkar.ATDEV;

import java.util.List;

import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("students")
public class StudentResource 
{
	StudentRepository Stdrep=new StudentRepository();
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Student> getStudents() 
	{
		System.out.print("successfully applied....");
		return Stdrep.getStudents();
	}
	
	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Student getStudent(@PathParam("id") int id)
	{
		
		System.out.print("work");
		return Stdrep.getStudent(id);
	}
	
	@POST
	@Path("student")
	@Consumes(MediaType.APPLICATION_JSON) 
	public Student createStudent(Student s1)
	{
		System.out.println(s1);
		Stdrep.create(s1);
		return s1;
	}
	
	@PUT
	@Path("student")
	@Consumes(MediaType.APPLICATION_JSON) 
	public Student updateStudent(Student s1)
	{
		System.out.println(s1);
		Stdrep.update(s1);
		return s1;
	}
	
	@DELETE
	@Path("student/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Student deleteStudent(@PathParam("id") int id)
	{
		Student s=Stdrep.getStudent(id);
		if(s.getId()!=0)
			Stdrep.delete(id);
		return s;
	}
	
}