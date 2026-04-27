// 🔵 8. Coding Questions (Basic)
// Reverse a string without using built-in methods
// const reverse = () => {
//   const str = "abcdef";
//   let result = "";
//   // const result = str.split("").reverse().join("");
//   for (i = str.length - 1; i >= 0; i--) {
//     result += str[i];
//   }
//   console.log(result);
// };
// reverse();
// Check if a string is a palindrome
// const palindrome = () => {
//   const str = "madam";
//   let left = 0;
//   let right = str.length - 1;

//   while (left < right) {
//     if (str[left] !== str[right]) {
//       return false;
//     }
//     left++;
//     right--;
//   }

//   return true;
// };

// console.log(palindrome());
// Find the largest number in an array
// function maximum() {
//   let max = -1;
//   const arr = [1, 2, 3, 55, 5, 6];
//   for (i = 0; i < arr.length; i++) {
//     if (arr[i] > max) {
//       max = arr[i];
//     }
//   }
//   console.log(max);
// }
// maximum();
// // Find the smallest number in an array
// function minimum() {
//   let max = Math.min;
//   const arr = [1, 2, 3, 55, 5, 6];
//   for (i = 0; i < arr.length; i++) {
//     if (arr[i] < max) {
//       max = arr[i];
//     }
//   }
//   console.log(max);
// }
// minimum();
// Count vowels in a string

// Remove duplicates from an array
// const unique = () => {
//   let arr = [2, 2, 3, 3, 5, 5, 7, 7];
//   console.log(new Set(arr));
// };
// unique();
// Swap two variables without third variable
// const swap = () => {
//   let a = 5;
//   let b = 10;
//   [a, b] = [b, a];
//   console.log("a = ", a, "b = ", b);
// };
// swap();
// Check if a number is prime
// const prime = () => {
//   let num = 99;
//   if (num % 2 == 0) {
//     console.log("Prime");
//   } else {
//     console.log("not Prime");
//   }
// };
// prime();
// Find factorial using recursion
// function factorial() {
//   let result = 1;
//   for (i = 0; i < 5; i++) {
//     result += result * i;
//     console.log(result);
//   }

// }
// factorial();

// Generate Fibonacci series
// function fibonacci(n) {
//   if (n <= 1) {
//     return n;
//   }
//   let prev = 0;
//   let curr = 1;
//   for (i = 2; i <= n; i++) {
//     let next = prev + curr;
//     prev = curr;
//     curr = next;
//   }
//   return curr;
// }

// console.log(fibonacci(20));
//

// 🔵 9. Coding Questions (Intermediate)
// Flatten a nested array
// function flat() {
//   const arr = [1, 2, 3, 4, 5, [6, 7, [8, 9], 10]];
//   let flat = arr.flat(Infinity);
//   console.log(flat);
// }
// flat();
// Find duplicate elements in an array
// function duplicate() {
//   const arr = [1, 2, 2, 3, 4, 6, 7, 7];
//   for (i = 0; i < arr.length; i++) {
//     if (arr[i] == arr[i + 1]) {
//       console.log(arr[i]);
//     }
//   }
// }
// duplicate();
// Find the missing number in an array
// function missing() {
//   const arr = [1, 2, 3, 5, 6, 7, 8, 9];
//   let n = arr.length + 1;
//   let sum = (n * (n + 1)) / 2;
//   return sum - arr.reduce((a, b) => a + b, 0);
// }
// console.log(missing());
// Sort an array without using .sort()
// function sort() {
//   const arr = [2, 3, 57, 3, 21];

//   for (let i = 0; i < arr.length - 1; i++) {
//     for (let j = 0; j <= arr.length - 1 - i; j++) {
//       if (arr[j] > arr[j + 1]) {
//         let temp = arr[j];
//         arr[j] = arr[j + 1];
//         arr[j + 1] = temp;
//       }
//     }
//   }
//   for (let i = 0; i < arr.length; i++) {
//     console.log(arr[i]);
//   }
// }
// sort();
// Implement your own map() function
// Implement your own filter() function
// Implement your own reduce() function

// Find the intersection of two arrays
// const intersection = () => {
//   const arr1 = [2, 5, 8, 7];
//   const arr2 = [3, 5, 7, 0, 9, 8];
//   const result = arr1.filter((items) => arr2.includes(items));
//   console.log(result);
// };
// intersection();
// Find the frequency of elements in an array
function frequency() {
  const arr = [1, 2, 3, 4, 5, 2, 3, 2, 2, 1];
  let map = new Map();
  for (let item of arr) {
    if (map.has(item)) {
      map.set(item, map.get(item) + 1);
    } else {
      map.set(item, 1);
    }
  }
  console.log(map);
}
frequency();
// Group objects by a property
// 🔵 10. Coding Questions (Advanced)
// Implement debounce function
// Implement throttle function
// Deep clone an object

// Implement promise from scratch
// Implement call, apply, bind
// Implement currying function
// Create a custom event emitter
// Implement LRU cache
// Write a polyfill for Promise.all
// Build a simple task scheduler

// Type of
// console.log("typeof NaN = ", typeof NaN);
// console.log("typeof {} = ", typeof {});
// console.log("typeof null = ", typeof null);
// console.log("typeof undefined = ", typeof undefined);
// console.log("null == undefined = ", null == undefined);
// console.log("[] == ![] = ", [] == ![]);
// console.log(5 - "2");
// console.log("number +string = ", 0.002 + "0.003");
