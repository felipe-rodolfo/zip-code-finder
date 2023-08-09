package br.com.main;

import br.com.main.models.ZipCode;

import java.util.Scanner;

import static br.com.main.FetchCEP.fetchAndParseZIPCode;

public class Finder {
    private static final String URL_API = "https://viacep.com.br/ws/%s/json/";
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Type in a CEP for search");
        var search = input.nextLine();

        try {
            ZipCode zipCode = fetchAndParseZIPCode(search, URL_API);
            System.out.println(zipCode.toString());
            FileGenerator fileZipCode = new FileGenerator();
            fileZipCode.generatesJson(zipCode);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

    }

}
