package com.example.demo;

import java.io.FileNotFoundException;
import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MultitoolController implements ErrorController {

	private DocumentationService ds = new DocumentationService();
	private Calculator calc = new Calculator();
	private RPSGame rps = new RPSGame();
	private RPSBean rpsBean = new RPSBean();
	private FormReader formread = new FormReader();
	private CsvReader csv = new CsvReader();
	private ImageRandomizer img = new ImageRandomizer();

	@RequestMapping("/")
	public String start() {
		return ds.getDocumentation();
	}

	// Calculator
	@RequestMapping(value = "/calc/{opType}/{num1}/{num2}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public String calculator(@PathVariable String opType, @PathVariable String num1, @PathVariable String num2) {
		return calc.calculateNum(opType, num1, num2);
	}

	// Rock Paper Scissors
	@RequestMapping(value = "/rps", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public String rpsGame(@RequestParam String choice) {

		String returnString = rps.runGame(choice);
		
		String winStatusString = rps.getWinStatus();
		rpsBean.updateScore(winStatusString);

		return returnString;
	}
	
	@RequestMapping(value = "/rps", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public String rpsGame() {
		return rpsBean.toJson();
	}
	
	// Endpoint to form for RPS
	@RequestMapping(value = "/rpsform", method = RequestMethod.GET, produces = MediaType.TEXT_HTML_VALUE)
	public String formToHtml() throws FileNotFoundException, IOException {
		
		return formread.readFile("RPSform.html");
	}

	// CSV file to JSON
	@RequestMapping(value = "/csv", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public String csvReader() throws FileNotFoundException, IOException {
		
		return csv.readFile("sample.csv");
	}

	// Image Randomizer
	@RequestMapping(value = "/img", method = RequestMethod.GET, produces = MediaType.IMAGE_JPEG_VALUE)
	public void getImage(HttpServletResponse response) throws IOException {
		var imgFile = new ClassPathResource(img.randomizeImg());
		
		response.setContentType(MediaType.IMAGE_JPEG_VALUE);
		StreamUtils.copy(imgFile.getInputStream(), response.getOutputStream());
	}

	// When the user types an invalid input
	@RequestMapping(path = "/error", method = RequestMethod.GET, produces = MediaType.TEXT_HTML_VALUE)
	public String error() {
		return start();
	}

}
