package com.inventi.updownloadcsv.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inventi.updownloadcsv.service.CsvFileServices;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;



@RestController
public class DownloadCsvRestApi {
	
	@Autowired
	CsvFileServices csvFileService;

	/*
	 * Download CSV Files
	 */
	@GetMapping("/api/download/csv/")
	public void downloadFile(HttpServletResponse response) throws IOException {
		response.setContentType("text/csv");
		response.setHeader("Content-Disposition", "attachment; filename=customers.csv");
		csvFileService.loadFile(response.getWriter());
	}
}