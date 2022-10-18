import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.testng.Assert;
import org.testng.annotations.Test;

public class test1 {

	//count the number of names starting with alphabel A in list
	@Test
	public static void regular()
	{
		
		List<String> names = new ArrayList<>();
		names.add("Abhijeet");
		names.add("Don");
		names.add("Alkekhya");
		names.add("Adam");
		names.add("Ram");
		int count = 0;

		// using normal method
		for(int i = 0 ; i < names.size(); i++)
		{
			String actual = names.get(i);
			if(actual.startsWith("A"))
				count++;
		}
		System.out.println(count);
		
	}
	
	@Test
	public static void streamFilter()
	{
		List<String> names = new ArrayList<>();
		names.add("Abhijeet");
		names.add("Don");
		names.add("Alkekhya");
		names.add("Adam");
		names.add("Ram");
		int count = 0;

		// using stream method
		// there is no life for intermediate operation if no terminal operation
		// terminal operations will execute only if inter operation (filter) return true
		// we can create streams
		// how to use filter in Stream API
		System.out.println(names.stream().filter((s)-> s.startsWith("A")).count());
		
		long d = Stream.of("Abhijeet", "Don", "Alkekhya", "Adam", "Ram").filter(s->
		{
			s.startsWith("A");
			return false;
		}).count();
		System.out.println(d);
		
		// print all the names of arraylist
		names.stream().filter(s->s.length() > 4).forEach(s->System.out.println(s));
		names.stream().filter(s->s.length() > 4).limit(1).forEach(s->System.out.println(s));
	}	
	
	@Test
	public static void streamMap()
	{
		
		List<String> names = new ArrayList<>();
		names.add("man");
		names.add("Don");
		names.add("women");
		
		// Alekhya -> ALEKHYA
		// print names which have last letter as "a" with Uppercase
		Stream.of("Abhijeet", "Don", "Alkekhya", "Adam", "Rama").filter(s->s.endsWith("a")).map(s->s.toUpperCase()).forEach(s->System.out.println(s));
		
		// print names which have first letter as a with upper case and sorted
		List<String> names1 =  Arrays.asList("Azbhijeet", "Don", "Alkekhya", "Adam", "Rama");
		names1.stream().filter(s->s.startsWith("A")).sorted().map(s->s.toUpperCase()).forEach(s->System.out.println(s));
		
		//merging 2 different lists
		Stream<String>newStream = Stream.concat(names.stream(), names1.stream());
		//newStream.sorted().forEach(s->System.out.println(s));
		boolean flag = newStream.anyMatch(s->s.equalsIgnoreCase("Adam"));
		Assert.assertTrue(flag);
		
	}	
	
	
	@Test
	public static void streamCollect()
	{

		List<String> ls =  Stream.of("Abhijeet", "Don", "Alkekhya", "Adam", "Rama").filter(s->s.endsWith("a")).map(s->s.toUpperCase()).collect(Collectors.toList());
		System.out.println(ls.get(0));
		
		List<Integer> values = Arrays.asList(3, 2, 2, 7, 5, 1, 9, 7);
		// print unique number from this array
		// sort the array
		values.stream().distinct().forEach(s->System.out.println(s));
		List<Integer> li =  values.stream().distinct().sorted().collect(Collectors.toList());
		System.out.println(li.get(2));
		
		
	}	
	public static void main(String[] args) {
		//regular();
		//streamFilter();
		//streamMap();
		streamCollect();
	}

}
