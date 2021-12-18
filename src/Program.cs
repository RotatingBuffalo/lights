using lights.src.Graphics;
// ReSharper disable HeapView.ObjectAllocation.Evident
namespace lights.src
{
    class Program
    {
        private static Server s = new Server();

        // this stuff should probably all be moved to a singleton somewhere else, not cluttering up the main program file.
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
        // actually running now finally omegalul
        private static void runAlgo(Algo.Algorithm algo, int seconds)
        {

            Console.WriteLine($"Now running : {algo.Method.Name}");
            s.SetAlgorithm(algo);
            s.Run(10);
        }
        public static void Main(string[] args)
        {
            Console.CancelKeyPress += new ConsoleCancelEventHandler(Shutdown);
            Console.WriteLine("Attempting to connect!");
            s.Connect();
            Console.WriteLine("Connected! (supposedly, anyway.)");

            List<Algo.Algorithm> algos = new List<Algo.Algorithm>()
            {
                Algo.RGBFade,
                Algo.HueFade,
                Algo.HueWave
            };

            while (true)
            {
                foreach (var a in algos)
                {
                    runAlgo(a, 10);
                }
                Console.WriteLine("Ctrl^C to exit.");
            }
        }
        protected static void Shutdown(object? sender, ConsoleCancelEventArgs args)
        {
            s.Close();
            Console.WriteLine("\nCtrl+C Received. Shutting down.");
        }
    }
}
