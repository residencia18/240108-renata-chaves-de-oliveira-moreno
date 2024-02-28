/*#region Tuples Exemplo

var tuple3 = (id: 10, name: "Renata", born: new DateTime(1983,06,19));
Console.WriteLine($"tuple3 : (tuple3.id),(tuple3.name),(tuple3.born)");

List<(int id, string name, DateTime born)> list=new();
list.Add(tuple3);
list.Add(10, "Samuel", new DateTime(2012,12,20));
list.ForEach(x => Console.WriteLine($"Tuple 4: {x.id}, {x.name}, {x.born.ToShortDateString()}"))

#endregion */

#region LambdaExpression Examples

Func<int, int, int> sum = (x, y) => x + y;
Console.WriteLine($"Sum: {sum(10, 20)}");
// Sum: 30

Action<string> greet = name =>
{
   string greeting = $"Hello {name}!";
   Console.WriteLine(greeting);
};
string person = Console.ReadLine() ?? "";
greet(person);
// Hello `person or Someone`
// ?? and ??= are null-coalescing operators, 
//    which return the left-hand operand if the operand is not null; 
//    otherwise, they return the right operand.

Func<string, int, string> isBiggerThan = (string s, int x) => s.Length > x ? "Yes" : "No";
var size = 5;
Console.WriteLine($"The text {person} has more than {size} chars? {isBiggerThan(person, size)}");

string[] people = { "Renata", "Samuel", "Gabriel" };
char letter = 'S';
Console.WriteLine($"People with name started with '{letter}': {string.Join(", ", people.Where(x => x.Contains(letter)))}");

#endregion 

/* #region Linq Examples

List<int> list = new() { 1, 2, 3, 4, 5 };
var squaredList = list.Select(x => x * x);
Console.WriteLine($"Original List: {string.Join(", ", list)}");
Console.WriteLine($"Squared  List: {string.Join(", ", squaredList)}");
// Original List: 1, 2, 3, 4, 5
// Squared  List: 1, 4, 9, 16, 25
var summedList = list.Select((x,index) => x + squaredList.ElementAt(index));
Console.WriteLine($"Summed   List: {string.Join(", ", summedList)}");
// Summed   List: 2, 6, 12, 20, 30

var listMultipleOfThree = list.Where(x => x % 3 == 0).ToList();
listMultipleOfThree.AddRange(squaredList.Where(x => x % 3 == 0).ToList());
listMultipleOfThree.AddRange(summedList.Where(x => x % 3 == 0).ToList());
Console.WriteLine($"List Multiple of Three: {string.Join(", ", listMultipleOfThree)}");
// List Multiple of Three: 3, 9, 6, 12, 30
Console.WriteLine($"List Multiple of Three: {string.Join(", ", listMultipleOfThree.Order())}");

var students = new List<Student>{
   new Student(1, "Renata Chaves", "123456789", new DateTime(1983, 06, 19), new List<string>{"123456789", "73988342986"}),
   new Student(2, "Samuel CHOM", "987654321", new DateTime(2012, 12, 20), new List<string>{"123456789", "73987654321"}),
   new Student(3, "Gabriel CHOM", "123456789", new DateTime(2018, 10, 09), new List<string>{"123456789", "77988237086"})
};

var any = students.Any();
var anyHelder = students.Any(x => x.FullName.Contains("Helder"));
//var single = students.Single(x => x.Id == 10);
//throw exception
var singleOrDefault = students.SingleOrDefault(x => x.Id == 10);

var select = students.Select(x => x.PhoneNumbers);
var selectMany = students.SelectMany(x => x.PhoneNumbers);

var legalAge = students.Where(x => x.BirthDate <= DateTime.Today.AddYears(-18)).Select(x => x.FullName);
Console.WriteLine($"Legal age people: {string.Join(", ", legalAge)}");


Console.Read();
#endregion */


