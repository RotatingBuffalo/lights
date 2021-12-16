using lights.src.Graphics;
// ReSharper disable HeapView.ObjectAllocation.Evident
namespace lights.src
{
    class Program
    {
        private static int FrameCounter = 0;
        public static void ResetCounter()
        {
            FrameCounter = 0;
        }
        public static void IncrementCounter()
        {
            FrameCounter++;
        }
        public static int GetFrameCount()
        {
            return FrameCounter;
        }
        public static void Main(string[] args)
        {
            Server s = new Server();
            Console.WriteLine("Attempting to connect!");
            s.Connect();
            Console.WriteLine("Connected! (supposedly, anyway.)");
            Console.WriteLine("Now running : Algo.HueFade");
            s.SetAlgorithm(Algo.HueFade);
            s.Run(5);
            Console.WriteLine("Now running : Algo.RGBFade");
            s.SetAlgorithm(Algo.RGBFade);
            s.Run(5);
            Console.WriteLine("Now running : Algo.RGBWave");
            s.SetAlgorithm(Algo.RGBWave);
            s.Run(10);

            Console.WriteLine("Closing connection now!");
            s.Close();
            Console.WriteLine("Done!");
        }
    }
}
