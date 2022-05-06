package com.techelevator;

import javax.swing.*;

public class HomeworkAssignment {

<<<<<<< HEAD
//    instance attributes/variables

    private int earnedMarks;
//    The total number of correct marks submitter received on the assignment.
    private int possibleMarks;
//    The number of possible marks on the assignment.
    private String submitterName;
//    The submitter's name for the assignment.
    private String letterGrade;
//    | The letter grade for the assignment.

    //    create a constructor with 2 arguments
    public HomeworkAssignment(int possibleMarks, String submitterName) {

        this.possibleMarks = possibleMarks;
        this.submitterName = submitterName;

    }

//    create getter(s) and setter(s)
//        Getters
        public int getEarnedMarks()
        {return earnedMarks;}

        public int getPossibleMarks() {return possibleMarks;}

        public String getSubmitterName()
        {return submitterName;}

        private String letterGrade()
        {return letterGrade;}

//        Setters
        public void setEarnedMarks(int earnedMarks) {this.earnedMarks = earnedMarks;}

//    derive attribute calculation (method)
        public String getLetterGrade() {


        int logic = (earnedMarks * 100) / possibleMarks;

//        earnedMarks: total number of correct marks timing it by 100
//       possibleMarks: number of possible marks dividing
//         submitterName: submitter's name
//          letterGrade: letter grade


        if (logic >= 90) {
            return "A";
//                    0.9 * 100 = 90%
    }
            else if (logic <= 89 && logic >= 80){
                return "B";

//                0.8 * 100 = 80%

            } else if (logic <= 79 && logic >= 70) {
                 return "C";

             } else if (logic <= 69 && logic >= 60) {
            return "D";

        }  else;
                return "F";

        }
    }
=======
}
>>>>>>> upstream/main
