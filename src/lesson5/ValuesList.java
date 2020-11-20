package lesson5;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class ValuesList {
    public static void writeFile(Val vallist) {
            try ( PrintWriter out = new PrintWriter("w values.csv")) {
            for (String v : vallist.getHeader()) {
                out.print(v + ":");
            }
            out .println();

            int[][] vallistData = vallist.getData();
            for (int i = 0; i < vallistData.length; i++){
                for (int j = 0; j < vallistData[i].length; j++){
                    out.print(vallistData[i][j] + ";");
                }
                out.write("\r\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

private static Val readFile() throws IOException {
    BufferedReader in = new BufferedReader(new FileReader("values.csv"));
    List<int[]> dataArr = new ArrayList<>();
    String[] dataHeader = in.readLine().split(";");
    String readLine = null;
    while ((readLine = in.readLine()) != null) {
        List<Integer> lineArr = new ArrayList<>();
        String[] tokens = readLine.split(";");
        for (int i = 0; i < tokens.length; i++) {
            lineArr.add(Integer.parseInt(tokens[i]));
        }
        dataArr.add(lineArr.stream().mapToInt( i -> i).toArray());
    }
        Val vallist2 = new Val(dataHeader, dataArr.toArray(new int [0][]));
        int[][] tt = vallist2.getData();
        return vallist2;
}

    public static void main(String[] args) throws IOException {
        String[] header = {"Val1", "Val2", "Val3"};
        int[][] data = {{500, 700, 300}, {700, 100, 100}, {800, 100, 200}, {111, 111, 111}};
        Val vallist = new Val(header, data);
        writeFile(vallist);

        try {
            Val readedCsv = readFile();
            for (String v : readedCsv.getHeader()) {
                System.out.print(v + ";");
            }
            System.out.println();
            int[][]readetCsvData = readedCsv.getData();
            for (int i = 0; i < readetCsvData.length; i++) {
                for (int  j = 0; j < readetCsvData[i].length; j++) {
                    System.out.print(readetCsvData[i][j] + ";");
                }
                System.out.print("\r\n");

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
