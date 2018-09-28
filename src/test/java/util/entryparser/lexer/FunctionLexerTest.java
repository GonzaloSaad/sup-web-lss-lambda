package util.entryparser.lexer;

import org.junit.Test;

import java.util.InputMismatchException;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

public class FunctionLexerTest {


    private static final String NORMAL_INPUT = "A*6*x+B*log(cos(x))+C*e^x";
    private static final String INVALID_INPUT = "!A*6*x";
    private static final String NUMBER_INPUT = "3.2505*x";

    private static final Token FIRST_NORMAL_TOKEN = new Token("COEFF", "A");
    private static final Token EIGHTH_NORMAL_TOKEN = new Token("OP", "*");

    private static final Token FIRST_NUMBER_TOKEN = new Token("NUMBER", "3.2505");

    private static final int FIRST_TOKEN_INDEX = 0;
    private static final int EIGHTH_TOKEN_INDEX = 7;

    private FunctionLexer lexer;


    @Test
    public void testHappyScenarioWithNormalFunction(){
        lexer = new FunctionLexer(NORMAL_INPUT);
        List<Token> tokenList = lexer.tokenize();
        assertEquals(FIRST_NORMAL_TOKEN, tokenList.get(FIRST_TOKEN_INDEX));
        assertEquals(EIGHTH_NORMAL_TOKEN, tokenList.get(EIGHTH_TOKEN_INDEX));
    }

    @Test(expected = InputMismatchException.class)
    public void testNotHappyScenarioWithInvalidCharacter(){
        lexer = new FunctionLexer(INVALID_INPUT);
        lexer.tokenize();
    }

    @Test
    public void testNumberFunction(){
        lexer = new FunctionLexer(NUMBER_INPUT);
        List<Token> tokenList = lexer.tokenize();
        assertEquals(FIRST_NUMBER_TOKEN, tokenList.get(FIRST_TOKEN_INDEX));
    }
}
