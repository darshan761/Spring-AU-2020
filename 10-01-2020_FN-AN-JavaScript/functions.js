var arr1 = [1, 2, 3, 4, 5, 6, 7];
var arr2 = ["Aston Marin", "Audi", "Bentley", "Bugatti", "BMW", "Lamborghini", "Ferrari", "Rolls Royce", "Audi"];


// concat()
console.log(arr1.concat(arr2));
// [
//     1,             2,
//     3,             4,
//     5,             6,
//     7,             'Aston Marin',
//     'Audi',        'Bentley',
//     'Bugatti',     'BMW',
//     'Lamborghini', 'Ferrari',
//     'Rolls Royce', 'Audi'
//   ]


// every()
console.log(arr1.every(i => (i > 0))); // true
console.log(arr1.every(i => (i > 4))); // true


// filter()
console.log(arr1.filter(i => (i > 4)));
//[ 5, 6, 7 ]

console.log(arr2.filter(i => (i.charAt(0) == 'A')));
//[ 'Aston Marin', 'Audi', 'Audi' ]

console.log(arr2.filter(i => (i.charAt(i.length - 1) == 'i')));
// [ 'Audi', 'Bugatti', 'Lamborghini', 'Ferrari', 'Audi' ]


// forEach()
arr1.forEach(i => (console.log(i * 2)));
// 2
// 4
// 6
// 8
// 10
// 12
// 14


// indexOf() lastIndexOf()
console.log(arr2.indexOf("Audi")); //1
console.log(arr2.lastIndexOf("Audi")); //8


// join()
console.log(arr1.join("|"));
//1|2|3|4|5|6|7

console.log(arr2.join("|"));
//Aston Marin|Audi|Bentley|Bugatti|BMW|Lamborghini|Ferrari|Rolls Royce|Audi


// map()
console.log(arr1.map(i => (i * i)));
// [
//     1,  4,  9, 16,
//    25, 36, 49
//  ]


// pop()
console.log(arr1.pop()); // 7
console.log(arr1);
//[ 1, 2, 3, 4, 5, 6 ]


// push()
arr1.push(8);
console.log(arr1);
// [
//   1, 2, 3, 4,
//   5, 6, 8
// ]


//  reduce() 
console.log(arr1.reduce((x, y) => (x - y))); //-27


//  reduceRight() 
console.log(arr1.reduceRight((x, y) => (x - y))); //-13


// reverse()
console.log(arr1.reverse());
// [
//     8, 6, 5, 4,
//     3, 2, 1
//   ]


// shift()
arr1.shift();
console.log(arr1);
//[ 6, 5, 4, 3, 2, 1 ]


// some()
console.log(arr1.some(i => (i > 4)));
//true

console.log(arr1.some(i => (i > 7)));
//false


//toString()
console.log(arr1.toString());
//6,5,4,3,2,1


//unshift()
arr1.unshift(9);
console.log(arr1);
// [
//     9, 6, 5, 4,
//     3, 2, 1
//   ]


// sort()
console.log(arr1.sort());
// [
//     1, 2, 3, 4,
//     5, 6, 9
//   ]

console.log(arr2.sort());
// [
//     'Aston Marin',
//     'Audi',
//     'Audi',
//     'BMW',
//     'Bentley',
//     'Bugatti',
//     'Ferrari',
//     'Lamborghini',
//     'Rolls Royce'
//   ]


// splice()
arr1.splice(2, 2, 3, 8);
console.log(arr1);
// [
//     1, 2, 3, 8,
//     5, 6, 9
//   ]

arr2.splice(2, 1, "Alfa Romeo", "Accura");
console.log(arr2);
// [
//     'Aston Marin', 'Audi',
//     'Alfa Romeo',  'Accura',
//     'BMW',         'Bentley',
//     'Bugatti',     'Ferrari',
//     'Lamborghini', 'Rolls Royce'
//   ]


//slice()
console.log(arr1.slice(3, 6));
//[ 4, 5, 6 ]

console.log(arr2.slice(4, 8));
//[ 'BMW', 'Bentley', 'Bugatti', 'Ferrari' ]