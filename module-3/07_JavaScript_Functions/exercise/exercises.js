/**
 * Write a function called isAdmitted. It will check entrance
 * scores and return true if the student is admitted and
 * false if rejected. It takes three parameters:
 *
 *     * gpa
 *     * satScore (optional)
 *     * recommendation (optional)
 *
 * Admit them--return true--if:
 * 
 * gpa is above 4.0 
 * 
 * OR
 * 
 * SAT score is above 1300 
 * 
 * 
 * OR
 * 
 * gpa is above 3.0 and they have a recommendation 
 * 
 * OR
 * 
 * SAT score is above 1200 and they have a recommendation
 * 
 * OTHERWISE reject it
 *
 * @param {number} gpa the GPA of the student, between 4.2 and 1.0
 * @param {number} [satScore=0] the student's SAT score
 * @param {boolean} [recommendation=false] does the student have a recommendation
 * @returns {boolean} true if they are admitted
 */

    function isAdmitted (gpa, satScore, recommendation) {
        if (gpa > 4.0 || satScore > 1300) {
            return true;
        }
        else if (recommendation == true && (gpa > 3.0 || satScore > 1200)) {
            return true;
        }
        return false;
    }

    // console.log(isAdmitted(4.2));
    // result true

/**
 * Write a function called useParameterToFilterArray that takes an anonymous
 * function and uses that in the `unfilteredArray` filter function. Return the result.
 *
 * @param {function} filterFunction the function to filter with
 * @returns {number[]} the filtered array
 */


function useParameterToFilterArray (filterFunction){

    let unfilteredArray = [1, 2, 3, 4, 5, 6];

    return unfilteredArray.filter(filterFunction);
}


/**
 * Write a function called makeNumber that takes two strings
 * of digits, concatenates them together, and returns
 * the value as a number.
 *
 * So if two strings are passed in "42293" and "443", then this function
 * returns the number 42293443.
 *
 * @param {string} first the first string of digits to concatenate
 * @param {string} [second=''] the second string of digits to concatenate
 * @returns {number} the resultant number
 */


function makeNumber(first, second = '') {

    let string = first + second;

    return parseInt(string);
}

// console.log(makeNumber('23456', '593484'));
// result 23456593484



/**
 * Write a function called addAll that takes an unknown number of parameters
 * and adds all of them together. Return the sum.
 *
 * @param {...number} num a series of numbers to add together
 * @returns {number} the sum of all the parameters (or arguments)
 */

    function addAll(...numbers) {

        if (numbers.length == 0) {
            return 0;
        } else {
            return numbers.reduce(function (sum, numbers) {
                return sum + numbers;
            })
        }
    }
    
// console.log(addAll(1,2,3));
// console.log(addAll(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
// result 6
// result 55



/*
 * Write and document a function called makeHappy that takes
 * an array and prepends 'Happy ' to the beginning of all the
 * words and returns them as a new array. Use the `map` function.
 */

// * Takes an array of words and returns a new array with
// * the word Happy prepended to all the words.
// *
// * @param {string[]} words an array of words to add happy to
// * @returns {string[]} the same words but with 'Happy' prepended


    function makeHappy(words) {

    return words.map((word) => {
        return "Happy " + word;
    });
}

// console.log(makeHappy(['days', 'feet', 'dance']));
// result ['Happy days', 'Happy feet', 'Happy dance']
    

/*
 * Write and document a function called getFullAddressesOfProperties
 * that takes an array of JavaScript objects containing the
 * following keys:
 *     * streetNumber
 *     * streetName
 *     * streetType
 *     * city
 *     * state
 *     * zip
 *
 * /**
 * Take an array of properties and return the formatted postal
 * addresses. Address parts should be put in order and separated
 * by spaces.
 *
 * @param {object[]} properties array of objects to format
 * @param {number|string} properties[].streetNumber the street number of the property
 * @param {string} properties[].streetName the name of the street the property is on
 * @param {string} properties[].streetType the abbreviation of the street after the street name
 * @param {string} properties[].city the city the property is in
 * @param {string} properties[].state the state the city is in
 * @param {string} properties[].zip the zip code of the property
 * @returns {string[]} array of formatted properties
 * 
 * 
 * and returns an array of strings that turns the JavaScript objects
 * into a mailing address in the form of:
 *     streetNumber streetName streetType city state zip
 *
 * Use `map` and an anonymous function.
 */


    function getFullAddressesOfProperties(properties) {
        return properties.map((p) => {
            return [p.streetNumber, p.streetName, p.streetType, p.city, p.state, p.zip].join(' ');
        });
    }

    
    



/*
 * Write and document a function called findLargest.
 *
 * Using `forEach`, find the largest element in an array.
 * It must work for strings and numbers.
 */





 function findLargest(value) {
           let largest = value[0];

           value.forEach(element => {
               if (largest < element) {
                    largest = element;
               }
           });
           return largest;
       }

// console.log(findLargest(['aardvark', 'zebra', 'mongoose', 'hippo']));
// result zebra



/*
 * CHALLENGE
 * Write and document a function called getSumOfSubArrayValues.
 *
 * Take an array of arrays, adds up all sub values, and returns
 * the sum. For example, if you got this array as a parameter:
 * [
 *   [1, 2, 3],
 *   [2, 4, 6],
 *   [5, 10, 15]
 * ];
 *
 * The function returns 48. To do this, you will use two nested `reduce`
 * calls with two anonymous functions.
 *
 * Read the tests to verify you have the correct behavior.
 */
