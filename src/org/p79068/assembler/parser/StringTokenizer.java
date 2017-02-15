package org.p79068.assembler.parser;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


final class StringTokenizer extends Tokenizer {
	
	private static class TokenPattern {
		
		public final Pattern pattern;
		
		public final TokenType tokenType;
		
		
		public TokenPattern(String pattern, TokenType tokenType) {
			if (pattern == null)
				throw new NullPointerException();
			this.pattern = Pattern.compile(pattern);
			this.tokenType = tokenType;
		}
		
		
		@Override
		public String toString() {
			return String.format("[%s: /%s/]", tokenType, pattern);
		}
		
	}
	
	
	
	private static List<TokenPattern> patterns;
	
	static {
		patterns = new ArrayList<TokenPattern>();
		patterns.add(new TokenPattern("^[ \t]+", null));  // Whitespace
		patterns.add(new TokenPattern("^[A-Za-z_][A-Za-z0-9_]*:", TokenType.LABEL));
		// add support for unicode names
		patterns.add(new TokenPattern("^[赋A-Za-z_][A-Za-z0-9_]*", TokenType.NAME));
		patterns.add(new TokenPattern("^%[A-Za-z][A-Za-z0-9_]*", TokenType.REGISTER));
		patterns.add(new TokenPattern("^0[xX][0-9a-fA-F]+", TokenType.HEXADECIMAL));
		patterns.add(new TokenPattern("^-?[0-9]+", TokenType.DECIMAL));
		patterns.add(new TokenPattern("^\\$", TokenType.DOLLAR));
		patterns.add(new TokenPattern("^,", TokenType.COMMA));
		patterns.add(new TokenPattern("^\\+", TokenType.PLUS));
		patterns.add(new TokenPattern("^-", TokenType.MINUS));
		patterns.add(new TokenPattern("^\\(", TokenType.LEFT_PAREN));
		patterns.add(new TokenPattern("^\\)", TokenType.RIGHT_PAREN));
		patterns.add(new TokenPattern("^[\n\r]+", TokenType.NEWLINE));
		patterns.add(new TokenPattern("^#[^\n\r]*", null));  // Comment
		patterns.add(new TokenPattern("^$", TokenType.END_OF_FILE));
	}
	
	
	/**
	 * Reads the contents of the specified file, appends a newline character ({@code '\n'}), and returns the result.
	 * @param file the file to read from
	 * @return the contents of the file as a string, plus a trailing newline
	 * @throws IOException if an I/O exception occurred
	 */
	private static String read(File file) throws IOException {
		if (file == null)
			throw new NullPointerException();
		
		Reader in = new InputStreamReader(new BufferedInputStream(new FileInputStream(file)));
		
		StringBuilder sb = new StringBuilder();
		char[] buffer = new char[32 * 1024];
		while (true) {
			int read = in.read(buffer);
			if (read == -1)
				break;
			sb.append(buffer, 0, read);
		}
		
		sb.append('\n');
		
		return sb.toString();
	}
	
	
	
	private String sourceCode;
	
	private int offset;
	
	
	
	public StringTokenizer(File file) throws IOException {
		if (file == null)
			throw new NullPointerException();
		sourceCode = read(file);
		offset = 0;
	}
	
	
	StringTokenizer(String sourceCode) {
		if (sourceCode == null)
			throw new NullPointerException();
		this.sourceCode = sourceCode;
		offset = 0;
	}
	
	
	
	/**
	 * Returns the next token from this tokenizer.
	 * @return the next token from this tokenizer
	 */
	@Override
	public Token next() {
		for (TokenPattern pat : patterns) {
			String match = match(pat.pattern);
			if (match != null) {
				offset += match.length();
				if (pat.tokenType != null)
					return new Token(pat.tokenType, match);
				else
					return next();
			}
		}
		throw new RuntimeException("No token pattern match");
	}
	
	
	private String match(Pattern pattern) {
		Matcher m = pattern.matcher(sourceCode);
		m.region(offset, sourceCode.length());
		if (!m.find())
			return null;
		else
			return m.group();
	}
	
}
