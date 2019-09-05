using System;
using System.Threading;
namespace writer_boi
{
    class Program
    {
        static void Main(string[] args)
        {
            int totalTime = int.Parse(args[0]);
            int timePerLine = totalTime/50;
            for(int i = 0;i < 5000;i += 100){
                Console.WriteLine($"This is line {i}");
                Thread.Sleep(timePerLine);
            }
        }
    }
}
