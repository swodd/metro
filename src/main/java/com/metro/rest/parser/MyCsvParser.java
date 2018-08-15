package com.metro.rest.parser;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.metro.rest.entity.Customer;
import de.siegmar.fastcsv.reader.CsvContainer;
import de.siegmar.fastcsv.reader.CsvReader;
import de.siegmar.fastcsv.reader.CsvRow;
import de.siegmar.fastcsv.writer.CsvWriter;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;

public class MyCsvParser {

    private Date curDate = new Date();
    SimpleDateFormat format = new SimpleDateFormat();
    private String dateToStr = format.format(curDate);

    public String read (Long fileName) {
           StringBuilder s= new StringBuilder();
           File file = new File(fileName + ".csv");
           CsvReader csvReader = new CsvReader();

           CsvContainer csv = null;
           try {
               csv = csvReader.read(file, StandardCharsets.UTF_8);
           } catch (IOException e) {
               e.printStackTrace();
           }
           for (CsvRow row : csv.getRows()) {
               s.append(row.getField(0));

           }
           return s.toString();
    }

    public void write(Customer customer) {

            format = new SimpleDateFormat("yyyyMMddhhmm");
            dateToStr = format.format(curDate);

            File file = new File(dateToStr + ".csv");
            CsvWriter csvWriter = new CsvWriter();
            ObjectMapper mapper = new ObjectMapper();


            //Object to JSON in String
            String jsonInString = null;
            try {
                jsonInString = mapper.writeValueAsString(customer);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }

            try {
                csvWriter.write(file, StandardCharsets.UTF_8, Collections.singleton(new String[]{jsonInString}));
            } catch (IOException e) {
                e.printStackTrace();
            }
    }

    public String getDateToStr() {
            return dateToStr;
    }
}
