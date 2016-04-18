package web;

import csp.Sudoku;
import org.json.*;

import java.util.HashSet;
import java.util.Set;

public class SudokuJSONSerializer {

    static Sudoku fromJSON(String string) {
        JSONObject root = new JSONObject(new JSONTokener(string));
        return new Sudoku(parseGivens(root), root.getInt("boxesPerRow"), root.getInt("boxesPerColumn"));
    }

    static String toJSON(Sudoku sudoku) {
        JSONArray arr = new JSONArray();

        if (!sudoku.isSolved()) {
            sudoku.getGivens().forEach((given) -> arr.put(stringifyCandidate(given)));
            return new JSONStringer()
                    .object()
                    .key("givens")
                    .value(arr)
                    .endObject()
                    .toString();
        }
        else {
            sudoku.getSolution().forEach((candidate) -> arr.put(stringifyCandidate(candidate)));
            return new JSONStringer()
                    .object()
                    .key("solution")
                    .value(arr)
                    .endObject()
                    .toString();
        }
    }

    private static Set<Sudoku.Candidate> parseGivens(JSONObject root) {
        JSONArray givens = root.getJSONArray("givens");

        Set<Sudoku.Candidate> candidates = new HashSet<>();
        for (int i = 0; i < givens.length(); ++i) {
            candidates.add(parseCandidate(givens.getJSONObject(i)));
        }
        return candidates;
    }

    private static Sudoku.Candidate parseCandidate(JSONObject candidate) {
        return new Sudoku.Candidate(candidate.getInt("row"), candidate.getInt("column"), candidate.getInt("digit"));
    }

    private static JSONObject stringifyCandidate(Sudoku.Candidate candidate) {
        JSONObject blob = new JSONObject();
        blob.put("row", candidate.row);
        blob.put("column", candidate.column);
        blob.put("digit", candidate.digit);
        return blob;
    };
}
