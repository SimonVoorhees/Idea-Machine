package com.example.SlopIdeas;

import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Service;

import com.opencsv.CSVReader;

@Service
public record IdeaService() {

    public List<String> readAllLinesExample() throws Exception {
        Path path = Paths.get(
                ClassLoader.getSystemResource("SlopNames.csv").toURI());
        return Files.readAllLines(path);
    }

    public List<String[]> readAllLines(Path filePath) throws Exception {
        try (Reader reader = Files.newBufferedReader(filePath)) {
            try (CSVReader csvReader = new CSVReader(reader)) {
                return csvReader.readAll();
            }
        }
    }

    public List<String> quickRead() throws Exception {

        return null;
    }

    public List<String> getRandomIdeas(long amount) throws Exception {
        try {
            List<String> ideaList = readAllLinesExample();
            if (amount >= ideaList.size()) {
                return ideaList;
            }
            List<String> randomIdeas = new ArrayList<>();
            Random rand = new Random();
            for (long i = 0; i < amount; i++) {
                randomIdeas.add(ideaList.remove(rand.nextInt(ideaList.size())));
            }

            return randomIdeas;

        } catch (Exception e) {
            System.err.println(e.toString());
            List<String> errorList = new ArrayList<>();
            errorList.add(e.toString());
            errorList.add("" + amount);
            return errorList;
        }
    }

    public List<IdeaGroup> getRandomIdeaGroups(int groups, int amountPerGroup) throws Exception {
        try {
            List<String> ideaList = readAllLinesExample();
            if (amountPerGroup*groups > ideaList.size()) {
                return null;
            }
            List<IdeaGroup> randomIdeas = new ArrayList<>();
            Random rand = new Random();
            for (int i = 0; i < groups; i++) {
                String[] group = new String[amountPerGroup];
                for (int j = 0; j < amountPerGroup; j++) {
                    group[j] = ideaList.remove(rand.nextInt(ideaList.size()));
                }
                randomIdeas.add(new IdeaGroup(group));
            }

            return randomIdeas;

        } catch (Exception e) {
            System.err.println(e.toString());
            List<IdeaGroup> errorList = new ArrayList<>();
            String[] error = new String[3];
            error[0] = e.toString();
            error[1] = ("groups: " + groups);
            error[2] = ("amountPerGroup" + amountPerGroup);
            errorList.add(new IdeaGroup(error));
            return errorList;
        }
    }

}