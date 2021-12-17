using lights.src.Graphics;
// ReSharper disable HeapView.ObjectAllocation.Evident
namespace lights.src
{
    class Program
    {
        private static Server s = new Server();
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
            Console.CancelKeyPress += new ConsoleCancelEventHandler(Shutdown);
            Console.WriteLine("Attempting to connect!");
            s.Connect();
            Console.WriteLine("Connected! (supposedly, anyway.)");
            while (true)
            {
                Console.WriteLine("Now running : Algo.RGBFade");
                Console.WriteLine("(Ctrl^C to exit.)");
                s.SetAlgorithm(Algo.RGBFade);
                s.Run(10);

                Console.WriteLine("Now running : Algo.HueFade");
                Console.WriteLine("(Ctrl^C to exit.)");
                s.SetAlgorithm(Algo.HueFade);
                s.Run(10);

                Console.WriteLine("Now running : Algo.HueWave");
                Console.WriteLine("(Ctrl^C to exit.)");
                s.SetAlgorithm(Algo.HueWave);
                s.Run(10);
            }
        }
        protected static void Shutdown(object? sender, ConsoleCancelEventArgs args)
        {
            s.Close();
            Console.WriteLine("\nCtrl+C Received. Shutting down.");
        }
    }
}
