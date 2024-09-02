//package asia.fourtitude.interviewq.jumble.controller;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.context.annotation.Import;
//import org.springframework.test.web.servlet.MockMvc;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//
//import asia.fourtitude.interviewq.jumble.TestConfig;
//import asia.fourtitude.interviewq.jumble.core.JumbleEngine;
//
//@WebMvcTest(GameApiController.class)
//@Import(TestConfig.class)
//class GameApiControllerTest {
//
//    static final ObjectMapper OM = new ObjectMapper();
//
//    @Autowired
//    private MockMvc mvc;
//
//    @Autowired
//    JumbleEngine jumbleEngine;
//
//    /*
//     * NOTE: Refer to "RootControllerTest.java", "GameWebControllerTest.java"
//     * as reference. Search internet for resource/tutorial/help in implementing
//     * the unit tests.
//     *
//     * Refer to "http://localhost:8080/swagger-ui/index.html" for REST API
//     * documentation and perform testing.
//     *
//     * Refer to Postman collection ("interviewq-jumble.postman_collection.json")
//     * for REST API documentation and perform testing.
//     */
//
//    @Test
//    void whenCreateNewGame_thenSuccess() throws Exception {
//        /*
//         * Doing HTTP GET "/api/game/new"
//         *
//         * Input: None
//         *
//         * Expect: Assert these
//         * a) HTTP status == 200
//         * b) `result` equals "Created new game."
//         * c) `id` is not null
//         * d) `originalWord` is not null
//         * e) `scrambleWord` is not null
//         * f) `totalWords` > 0
//         * g) `remainingWords` > 0 and same as `totalWords`
//         * h) `guessedWords` is empty list
//         */
//        assertTrue(false, "to be implemented");
//    }
//
//    @Test
//    void givenMissingId_whenPlayGame_thenInvalidId() throws Exception {
//        /*
//         * Doing HTTP POST "/api/game/guess"
//         *
//         * Input: JSON request body
//         * a) `id` is null or missing
//         * b) `word` is null/anything or missing
//         *
//         * Expect: Assert these
//         * a) HTTP status == 404
//         * b) `result` equals "Invalid Game ID."
//         */
//        assertTrue(false, "to be implemented");
//    }
//
//    @Test
//    void givenMissingRecord_whenPlayGame_thenRecordNotFound() throws Exception {
//        /*
//         * Doing HTTP POST "/api/game/guess"
//         *
//         * Input: JSON request body
//         * a) `id` is some valid ID (but not exists in game system)
//         * b) `word` is null/anything or missing
//         *
//         * Expect: Assert these
//         * a) HTTP status == 404
//         * b) `result` equals "Game board/state not found."
//         */
//        assertTrue(false, "to be implemented");
//    }
//
//    @Test
//    void givenCreateNewGame_whenSubmitNullWord_thenGuessedIncorrectly() throws Exception {
//        /*
//         * Doing HTTP POST "/api/game/guess"
//         *
//         * Given:
//         * a) has valid game ID from previously created game
//         *
//         * Input: JSON request body
//         * a) `id` of previously created game
//         * b) `word` is null or missing
//         *
//         * Expect: Assert these
//         * a) HTTP status == 200
//         * b) `result` equals "Guessed incorrectly."
//         * c) `id` equals to `id` of this game
//         * d) `originalWord` is equals to `originalWord` of this game
//         * e) `scrambleWord` is not null
//         * f) `guessWord` is equals to `input.word`
//         * g) `totalWords` is equals to `totalWords` of this game
//         * h) `remainingWords` is equals to `remainingWords` of previous game state (no change)
//         * i) `guessedWords` is empty list (because this is first attempt)
//         */
//        assertTrue(false, "to be implemented");
//    }
//
//    @Test
//    void givenCreateNewGame_whenSubmitWrongWord_thenGuessedIncorrectly() throws Exception {
//        /*
//         * Doing HTTP POST "/api/game/guess"
//         *
//         * Given:
//         * a) has valid game ID from previously created game
//         *
//         * Input: JSON request body
//         * a) `id` of previously created game
//         * b) `word` is some value (that is not correct answer)
//         *
//         * Expect: Assert these
//         * a) HTTP status == 200
//         * b) `result` equals "Guessed incorrectly."
//         * c) `id` equals to `id` of this game
//         * d) `originalWord` is equals to `originalWord` of this game
//         * e) `scrambleWord` is not null
//         * f) `guessWord` equals to input `guessWord`
//         * g) `totalWords` is equals to `totalWords` of this game
//         * h) `remainingWords` is equals to `remainingWords` of previous game state (no change)
//         * i) `guessedWords` is empty list (because this is first attempt)
//         */
//        assertTrue(false, "to be implemented");
//    }
//
//    @Test
//    void givenCreateNewGame_whenSubmitFirstCorrectWord_thenGuessedCorrectly() throws Exception {
//        /*
//         * Doing HTTP POST "/api/game/guess"
//         *
//         * Given:
//         * a) has valid game ID from previously created game
//         *
//         * Input: JSON request body
//         * a) `id` of previously created game
//         * b) `word` is of correct answer
//         *
//         * Expect: Assert these
//         * a) HTTP status == 200
//         * b) `result` equals "Guessed correctly."
//         * c) `id` equals to `id` of this game
//         * d) `originalWord` is equals to `originalWord` of this game
//         * e) `scrambleWord` is not null
//         * f) `guessWord` equals to input `guessWord`
//         * g) `totalWords` is equals to `totalWords` of this game
//         * h) `remainingWords` is equals to `remainingWords - 1` of previous game state (decrement by 1)
//         * i) `guessedWords` is not empty list
//         * j) `guessWords` contains input `guessWord`
//         */
//        assertTrue(false, "to be implemented");
//    }
//
//    @Test
//    void givenCreateNewGame_whenSubmitAllCorrectWord_thenAllGuessed() throws Exception {
//        /*
//         * Doing HTTP POST "/api/game/guess"
//         *
//         * Given:
//         * a) has valid game ID from previously created game
//         * b) has submit all correct answers, except the last answer
//         *
//         * Input: JSON request body
//         * a) `id` of previously created game
//         * b) `word` is of the last correct answer
//         *
//         * Expect: Assert these
//         * a) HTTP status == 200
//         * b) `result` equals "All words guessed."
//         * c) `id` equals to `id` of this game
//         * d) `originalWord` is equals to `originalWord` of this game
//         * e) `scrambleWord` is not null
//         * f) `guessWord` equals to input `guessWord`
//         * g) `totalWords` is equals to `totalWords` of this game
//         * h) `remainingWords` is 0 (no more remaining, game ended)
//         * i) `guessedWords` is not empty list
//         * j) `guessWords` contains input `guessWord`
//         */
//        assertTrue(false, "to be implemented");
//    }
//
//}

package asia.fourtitude.interviewq.jumble.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.fasterxml.jackson.databind.ObjectMapper;

import asia.fourtitude.interviewq.jumble.TestConfig;
import asia.fourtitude.interviewq.jumble.core.JumbleEngine;
import asia.fourtitude.interviewq.jumble.model.GameGuessInput;
import asia.fourtitude.interviewq.jumble.model.GameGuessOutput;

@WebMvcTest(GameApiController.class)
@Import(TestConfig.class)
class GameApiControllerTest {

    static final ObjectMapper OM = new ObjectMapper();

    @Autowired
    private MockMvc mvc;

    @Autowired
    JumbleEngine jumbleEngine;

    @Test
    void whenCreateNewGame_thenSuccess() throws Exception {
        MvcResult result = mvc.perform(get("/api/game/new"))
                .andExpect(status().isOk())
                .andReturn();

        String content = result.getResponse().getContentAsString();
        GameGuessOutput output = OM.readValue(content, GameGuessOutput.class);

        assertEquals("Created new game.", output.getResult());
        assertNotNull(output.getId());
        assertNotNull(output.getOriginalWord());
        assertNotNull(output.getScrambleWord());
        assertTrue(output.getTotalWords() > 0);
        assertEquals(output.getTotalWords(), output.getRemainingWords());
        assertTrue(output.getGuessedWords().isEmpty());
    }

    @Test
    void givenMissingId_whenPlayGame_thenInvalidId() throws Exception {
        GameGuessInput input = new GameGuessInput();
        input.setWord("test");

        mvc.perform(post("/api/game/guess")
                .contentType(MediaType.APPLICATION_JSON)
                .content(OM.writeValueAsString(input)))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.result").value("Invalid Game ID."));
    }

    @Test
    void givenMissingRecord_whenPlayGame_thenRecordNotFound() throws Exception {
        GameGuessInput input = new GameGuessInput();
        input.setId("non-existent-id");
        input.setWord("test");

        mvc.perform(post("/api/game/guess")
                .contentType(MediaType.APPLICATION_JSON)
                .content(OM.writeValueAsString(input)))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.result").value("Game board/state not found."));
    }

    @Test
    void givenCreateNewGame_whenSubmitNullWord_thenGuessedIncorrectly() throws Exception {
        // Create a new game
        MvcResult newGameResult = mvc.perform(get("/api/game/new")).andReturn();
        GameGuessOutput newGameOutput = OM.readValue(newGameResult.getResponse().getContentAsString(), GameGuessOutput.class);

        // Submit null word
        GameGuessInput input = new GameGuessInput();
        input.setId(newGameOutput.getId());
        input.setWord(null);

        MvcResult guessResult = mvc.perform(post("/api/game/guess")
                .contentType(MediaType.APPLICATION_JSON)
                .content(OM.writeValueAsString(input)))
                .andExpect(status().isOk())
                .andReturn();

        GameGuessOutput guessOutput = OM.readValue(guessResult.getResponse().getContentAsString(), GameGuessOutput.class);

        assertEquals("Guessed incorrectly.", guessOutput.getResult());
        assertEquals(newGameOutput.getId(), guessOutput.getId());
        assertEquals(newGameOutput.getOriginalWord(), guessOutput.getOriginalWord());
        assertNotNull(guessOutput.getScrambleWord());
        assertNull(guessOutput.getGuessWord());
        assertEquals(newGameOutput.getTotalWords(), guessOutput.getTotalWords());
        assertEquals(newGameOutput.getRemainingWords(), guessOutput.getRemainingWords());
        assertTrue(guessOutput.getGuessedWords().isEmpty());
    }

    @Test
    void givenCreateNewGame_whenSubmitWrongWord_thenGuessedIncorrectly() throws Exception {
        // Create a new game
        MvcResult newGameResult = mvc.perform(get("/api/game/new")).andReturn();
        GameGuessOutput newGameOutput = OM.readValue(newGameResult.getResponse().getContentAsString(), GameGuessOutput.class);

        // Submit wrong word
        GameGuessInput input = new GameGuessInput();
        input.setId(newGameOutput.getId());
        input.setWord("wrongword");

        MvcResult guessResult = mvc.perform(post("/api/game/guess")
                .contentType(MediaType.APPLICATION_JSON)
                .content(OM.writeValueAsString(input)))
                .andExpect(status().isOk())
                .andReturn();

        GameGuessOutput guessOutput = OM.readValue(guessResult.getResponse().getContentAsString(), GameGuessOutput.class);

        assertEquals("Guessed incorrectly.", guessOutput.getResult());
        assertEquals(newGameOutput.getId(), guessOutput.getId());
        assertEquals(newGameOutput.getOriginalWord(), guessOutput.getOriginalWord());
        assertNotNull(guessOutput.getScrambleWord());
        assertEquals("wrongword", guessOutput.getGuessWord());
        assertEquals(newGameOutput.getTotalWords(), guessOutput.getTotalWords());
        assertEquals(newGameOutput.getRemainingWords(), guessOutput.getRemainingWords());
        assertTrue(guessOutput.getGuessedWords().isEmpty());
    }

    @Test
    void givenCreateNewGame_whenSubmitFirstCorrectWord_thenGuessedCorrectly() throws Exception {
        // Create a new game
        MvcResult newGameResult = mvc.perform(get("/api/game/new")).andReturn();
        GameGuessOutput newGameOutput = OM.readValue(newGameResult.getResponse().getContentAsString(), GameGuessOutput.class);

        // Get a correct word (you may need to implement this method in JumbleEngine)
        String correctWord = jumbleEngine.getValidSubWord(newGameOutput.getOriginalWord());
        if (correctWord == null) {
            fail("No valid sub-word found for the original word");
        }

        // Submit correct word
        GameGuessInput input = new GameGuessInput();
        input.setId(newGameOutput.getId());
        input.setWord(correctWord);

        MvcResult guessResult = mvc.perform(post("/api/game/guess")
                .contentType(MediaType.APPLICATION_JSON)
                .content(OM.writeValueAsString(input)))
                .andExpect(status().isOk())
                .andReturn();

        GameGuessOutput guessOutput = OM.readValue(guessResult.getResponse().getContentAsString(), GameGuessOutput.class);

        assertEquals("Guessed correctly.", guessOutput.getResult());
        assertEquals(newGameOutput.getId(), guessOutput.getId());
        assertEquals(newGameOutput.getOriginalWord(), guessOutput.getOriginalWord());
        assertNotNull(guessOutput.getScrambleWord());
        assertEquals(correctWord, guessOutput.getGuessWord());
        assertEquals(newGameOutput.getTotalWords(), guessOutput.getTotalWords());
        assertEquals(newGameOutput.getRemainingWords() - 1, guessOutput.getRemainingWords());
        assertFalse(guessOutput.getGuessedWords().isEmpty());
        assertTrue(guessOutput.getGuessedWords().contains(correctWord));
    }

    @Test
    void givenCreateNewGame_whenSubmitAllCorrectWord_thenAllGuessed() throws Exception {
        // Create a new game
        MvcResult newGameResult = mvc.perform(get("/api/game/new")).andReturn();
        GameGuessOutput newGameOutput = OM.readValue(newGameResult.getResponse().getContentAsString(), GameGuessOutput.class);

        // Get all correct words (you may need to implement this method in JumbleEngine)
        String[] allWords = jumbleEngine.getAllValidSubWords(newGameOutput.getOriginalWord());
        if (allWords.length == 0) {
            fail("No valid sub-words found for the original word");
        }

        // Submit all words except the last one
        for (int i = 0; i < allWords.length - 1; i++) {
            GameGuessInput input = new GameGuessInput();
            input.setId(newGameOutput.getId());
            input.setWord(allWords[i]);

            mvc.perform(post("/api/game/guess")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(OM.writeValueAsString(input)));
        }

        // Submit the last word
        GameGuessInput lastInput = new GameGuessInput();
        lastInput.setId(newGameOutput.getId());
        lastInput.setWord(allWords[allWords.length - 1]);

        MvcResult guessResult = mvc.perform(post("/api/game/guess")
                .contentType(MediaType.APPLICATION_JSON)
                .content(OM.writeValueAsString(lastInput)))
                .andExpect(status().isOk())
                .andReturn();

        GameGuessOutput guessOutput = OM.readValue(guessResult.getResponse().getContentAsString(), GameGuessOutput.class);

        assertEquals("All words guessed.", guessOutput.getResult());
        assertEquals(newGameOutput.getId(), guessOutput.getId());
        assertEquals(newGameOutput.getOriginalWord(), guessOutput.getOriginalWord());
        assertNotNull(guessOutput.getScrambleWord());
        assertEquals(allWords[allWords.length - 1], guessOutput.getGuessWord());
        assertEquals(newGameOutput.getTotalWords(), guessOutput.getTotalWords());
        assertEquals(0, guessOutput.getRemainingWords());
        assertFalse(guessOutput.getGuessedWords().isEmpty());
        assertTrue(guessOutput.getGuessedWords().contains(allWords[allWords.length - 1]));
    }
}
