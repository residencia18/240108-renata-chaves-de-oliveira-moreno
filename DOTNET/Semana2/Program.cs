#region  DateTime Example

DateTime now = DateTime.Now;
Console.WriteLine($"Current data and time: " + now.ToString());

DateTime today = DateTime.Today;
Console.WriteLine($"Today's date: {today}");

DateTime tomorrow = now.AddDays(1);
Console.WriteLine($"Tomorrow's date: {tomorrow}");

#endregion