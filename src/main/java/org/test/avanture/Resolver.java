package org.test.avanture;


import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Resolver {
    private FileReader fileReader;
    private List<List<Character>> carte;
    public Position currentPosition;


    private void setFileReader() {
        final String FILE_NAME = "src/main/resources/carte.txt";
        try {
            fileReader = new FileReader(FILE_NAME);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void scanCarte() {
        List<List<Character>> f_carte = new ArrayList<>();
        List<Character> carteLine = new ArrayList<>();
        setFileReader();
        int c;
        try {
            while ((c = fileReader.read()) != -1) {
                if (c == '\n') {
                    carteLine.add((char) c);
                    f_carte.add(carteLine);
                    carteLine = new ArrayList<>();
                } else {
                    carteLine.add((char) c);
                }
            }
            fileReader.close();
            carte = f_carte;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void setPosition(Position position) {
        currentPosition = position;
    }

    public Position getPosition (Position initPosition, String directions) {
        setPosition(initPosition);
        scanCarte();
        for (char c : directions.toCharArray()) {
            move(c);
        }
        return currentPosition;
    }

    private void move (char direction) {
        boolean validPosition = carte.get(currentPosition.getY()).get(currentPosition.getX()) != '#';
        if (!validPosition) return;
        if (direction == 'N' && carte.get(currentPosition.getY()-1).get(currentPosition.getX()) == ' ') {
            currentPosition.setY(currentPosition.getY()-1);
        } else if (direction == 'S' && carte.get(currentPosition.getY()+1).get(currentPosition.getX()) == ' ') {
            currentPosition.setY(currentPosition.getY()+1);
        } else if (direction == 'E' && carte.get(currentPosition.getY()).get(currentPosition.getX()+1) == ' ') {
            currentPosition.setX(currentPosition.getX()+1);
        }else if (direction == 'O' && carte.get(currentPosition.getY()).get(currentPosition.getX()-1) == ' ') {
            currentPosition.setX(currentPosition.getX()-1);
        }
    }
}

