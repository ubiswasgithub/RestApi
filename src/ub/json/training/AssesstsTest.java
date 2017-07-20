package ub.json.training;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class AssesstsTest {
	
	URL jsonUrl = null;
	ObjectMapper mapper = new ObjectMapper();
	Assessts assets = null;
  @Test
  public void verifyCount() {
	  
	  int count = assets.getCount();
	 
	  
	  List<Results> result = assets.getResults();
	  
	/*  for(int i = 0; i<result.size(); i++){
		  System.out.println("Date = "+ result.get(i).getDate()+"  ID= "+result.get(i).getId());
	  }
	  */
	  
	  Assert.assertEquals(count, 10, "Assessts count doesnt match");
  }
  @BeforeTest
  public void beforeTest() throws JsonParseException, JsonMappingException, IOException {
	  
	 jsonUrl = new URL("https://api.nasa.gov/planetary/earth/assets?lon=100.75&lat=1.5&begin=2014-02-01&api_key=DEMO_KEY");
	 assets =  mapper.readValue(jsonUrl, Assessts.class);
	  
  }

  @AfterMethod
  public void afterMethod() {
  }

}
