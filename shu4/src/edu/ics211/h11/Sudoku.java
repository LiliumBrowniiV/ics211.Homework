package edu.ics211.h11;

import java.util.*;

public class Sudoku {

	  /* check that the sudoku rules hold in this sudoku puzzle.
	   * cells that contain 0 are not checked.
	   * @param the sudoku to be checked
	   * @param whether to print the error found, if any
	   * @return true if this sudoku obeys all of the sudoku rules, otherwise false
	   */
	  public static boolean checkSudoku (int [] [] sudoku, boolean printErrors)
	  {
	    if (sudoku.length != 9) {
	      if (printErrors) {
	        System.out.println ("sudoku has " + sudoku.length +
	                            " rows, should have 9");
	      }
	      return false;
	    }
	    for (int i = 0; i < sudoku.length; i++) {
	      if (sudoku [i].length != 9) {
	        if (printErrors) {
	          System.out.println ("sudoku row " + i + " has " +
	                              sudoku [i].length + " cells, should have 9");
	        }
	        return false;
	      }
	    }
	    /* check each cell for conflicts */
	    for (int i = 0; i < sudoku.length; i++) {
	      for (int j = 0; j < sudoku.length; j++) {
	        int cell = sudoku [i] [j];
	        if (cell == 0) {
	          continue;   /* blanks are always OK */
	        }
	        if ((cell < 1) || (cell > 9)) {
	          if (printErrors) {
	            System.out.println ("sudoku row " + i + " column " + j +
	                                " has illegal value " + cell);
	          }
	          return false;
	        }
	        /* does it match any other value in the same row? */
	        for (int m = 0; m < sudoku.length; m++) {
	          if ((j != m) && (cell == sudoku [i] [m])) {
	            if (printErrors) {
	              System.out.println ("sudoku row " + i + " has " + cell +
	                                  " at both positions " + j + " and " + m);
	            }
	            return false;
	          }
	        }
	        /* does it match any other value it in the same column? */
	        for (int k = 0; k < sudoku.length; k++) {
	          if ((i != k) && (cell == sudoku [k] [j])) {
	            if (printErrors) {
	              System.out.println ("sudoku column " + j + " has " + cell +
	                                  " at both positions " + i + " and " + k);
	            }
	            return false;
	          }
	        }
	        /* does it match any other value in the 3x3? */
	        for (int k = 0; k < 3; k++) {
	          for (int m = 0; m < 3; m++) {
	            int testRow = (i / 3 * 3) + k;   /* test this row */
	            int testCol = (j / 3 * 3) + m;   /* test this col */
	            if ((i != testRow) && (j != testCol) &&
	                (cell == sudoku [testRow] [testCol])) {
	              if (printErrors) {
	                System.out.println ("sudoku character " + cell + " at row " +
	                                    i + ", column " + j + 
	                                    " matches character at row " + testRow +
	                                    ", column " + testCol);
	              }
	              return false;
	            }
	          }
	        }
	      }
	    }
	    return true;
	  }

	  /* convert the sudoku to a printable string
	   * @param the sudoku to be converted
	   * @param whether to check for errors
	   * @return the printable version of the sudoku
	   */
	  public static String toString (int [] [] sudoku, boolean debug) {
	    if ((! debug) || (checkSudoku (sudoku, true))) {
	      String result = "";
	      for (int i = 0; i < sudoku.length; i++) {
	        if (i % 3 == 0) {
	          result = result + "+-------+-------+-------+\n";
	        }
	        for (int j = 0; j < sudoku.length; j++) {
	          if (j % 3 == 0) {
	            result = result + "| ";
	          }
	          if (sudoku [i] [j] == 0) {
	            result = result + "  ";
	          } else {
	            result = result + sudoku [i] [j] + " ";
	          }
	        }
	        result = result + "|\n";
	      }
	      result = result + "+-------+-------+-------+\n";
	      return result;
	    }
	    return "illegal sudoku";
	  }

	  /* find an assignment of values to sudoku cells that makes the sudoku valid
	   * @param the sudoku to be filled
	   * @return whether a solution was found 
	   *    if a solution was found, the sudoku is filled in with the solution
	   *    if no solution was found, restores the sudoku to its original value
	   */
	  public static boolean fillSudoku (int [] [] sudoku)  {
		  if(!checkSudoku(sudoku, false)) {
			  return false;
		  }
		  //these number are FIXED - they are not removed when backtracking 
		BitSet fixedNumbers = new BitSet(81);
		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 9; j++) {
				if(sudoku[i][j] != 0) {
					fixedNumbers.set(i*9+j);
				}
			}
		}
		int start = 0; 
		while(fixedNumbers.get(start)) {
			start++;
		}
		if(start == 81) {
			return true;
		}
		return fillSudokuAt(sudoku, start, fixedNumbers);
		//System.out.println ("fillSudoku is not yet implemented\n");
	    //return false;
	  }
	  private static boolean fillSudokuAt(int[][] sudoku, int position, BitSet fixedNumbers) {
		  if(position == 81) {
			  return checkSudoku(sudoku, false);
		  }
		  int ii = position / 9;
		  int jj = position % 9;
		  //get the next position
		  position++;
		  while(fixedNumbers.get(position)) {
				position++;
			}
		  
		  //guess number from 1 to 9
		  for(int guess = 1; guess < 10; guess++) {
			  //System.out.println("setting["+ ii+"][" + jj + "] = " +guess);
			  sudoku[ii][jj] = guess;
			  if(checkSudoku(sudoku, false)) {
				if(fillSudokuAt(sudoku, position, fixedNumbers)) {
					return true;
				}
			  }
		  }
		  //doesn't work - used up all of our guesses
		  sudoku[ii][jj] = 0;
		  //System.out.println(false);
		  return false;
	  }
	}
