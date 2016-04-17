package web;

import csp.Sudoku;
import org.json.*;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class SudokuJSONSerializer {

    static Sudoku fromJSON(String string) {
        JSONObject root = new JSONObject(new JSONTokener(string));
        return new Sudoku(parseGivens(root), root.getInt("boxesPerRow"), root.getInt("boxesPerColumn"));
    }

    static String toJSON(Sudoku sudoku) {
        if (!sudoku.isSolved()) {
            return new JSONStringer()
                    .object()
                    .key("solution")
                    .value(null)
                    .endObject()
                    .toString();
        }

        JSONArray candidates = new JSONArray();
        sudoku.getSolution().forEach((candidate) -> candidates.put(makeCandidate(candidate)));
        return new JSONStringer()
                .object()
                .key("givens")
                .value(candidates)
                .endObject()
                .toString();
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

    private static JSONObject makeCandidate(Sudoku.Candidate candidate) {
        JSONObject blob = new JSONObject();
        blob.put("row", candidate.row);
        blob.put("column", candidate.column);
        blob.put("digit", candidate.digit);
        return blob;
    };
}
