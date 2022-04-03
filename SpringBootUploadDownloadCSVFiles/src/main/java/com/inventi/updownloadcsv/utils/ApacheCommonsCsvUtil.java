package com.inventi.updownloadcsv.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;
import org.springframework.web.multipart.MultipartFile;

import com.inventi.updownloadcsv.model.Customer;



public class ApacheCommonsCsvUtil {
	private static String csvExtension = "csv";
	
	public static void customersToCsv(Writer writer, List<Customer> customers) throws IOException {

		try (CSVPrinter csvPrinter = new CSVPrinter(writer,
				CSVFormat.DEFAULT.withHeader("accountNumber","operationDateTime", "beneficiary","comment","amount","currency"));) {
			for (Customer customer : customers) {
				List<String> data = Arrays.asList(
									customer.getAccountNumber(),
									customer.getOperationDateTime(),
									customer.getBeneficiary(),
									customer.getComment(),
									String.valueOf(customer.getAmount()),
									customer.getCurrency()
						);

				csvPrinter.printRecord(data);
			}
			csvPrinter.flush();
		} catch (Exception e) {
			System.out.println("Writing CSV error!");
			e.printStackTrace();
		}
	}
	
	public static List<Customer> parseCsvFile(InputStream is) {
		BufferedReader fileReader = null;
		CSVParser csvParser = null;

		List<Customer> customers = new ArrayList<Customer>();

		try {
			fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
			csvParser = new CSVParser(fileReader,
					CSVFormat.DEFAULT);
			
			@Deprecated
			Iterable<CSVRecord> csvRecords = CSVFormat.RFC4180
					.withFirstRecordAsHeader()
					.withIgnoreHeaderCase()
					.withTrim()
					.withHeader("accountNumber","operationDateTime", "beneficiary","comment","amount","currency")
					.parse(fileReader);
			

			
			CSVFormat csvFormat = CSVFormat.DEFAULT;

			for (CSVRecord csvRecord : csvRecords) {
//				Customer customer = new Customer(Integer.parseInt(csvRecord.get("id")), csvRecord.get("address"),csvRecord.get("name"),Integer.parseInt(csvRecord.get("age")));

				Customer customer = new Customer(
						csvRecord.get("accountNumber"),
						csvRecord.get("operationDateTime"),
						csvRecord.get("beneficiary"),
						csvRecord.get("comment"),
						Integer.parseInt(csvRecord.get("amount")),
						csvRecord.get("currency")
								
								);
				
				customers.add(customer);
			}

		} catch (Exception e) {
			System.out.println("Reading CSV Error!");
			e.printStackTrace();
		} finally {
			try {
				fileReader.close();
				csvParser.close();
			} catch (IOException e) {
				System.out.println("Closing fileReader/csvParser Error!");
				e.printStackTrace();
			}
		}

		return customers;
	}
	
	public static boolean isCSVFile(MultipartFile file) {
		String extension = file.getOriginalFilename().split("\\.")[1];
		
		if(!extension.equals(csvExtension)) {
			return false;
		}
		
		return true;
	}

}