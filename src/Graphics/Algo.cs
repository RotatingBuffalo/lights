using lights.src;
namespace lights.src.Graphics
{
    class Algo
    {
        public delegate Frame Algorithm(Frame input);
        public static Frame HueFade(Frame f)
        {
            double i = Program.GetFrameCount() * Math.PI / 15;
            int r = (int)Math.Max(Math.Min(Math.Sin(i) * 255, 255), 0);
            int g = (int)Math.Max(Math.Min(Math.Sin(i + (2 * (Math.PI / 3))) * 255, 255), 0);
            int b = (int)Math.Max(Math.Min(Math.Sin(i + (4 * (Math.PI / 3))) * 255, 255), 0);
            return new Frame(new Color(r, g, b));
        }
        public static Frame RGBFade(Frame f)
        {
            int r = 0, g = 0, b = 0;
            int i = Program.GetFrameCount() * 17;
            int target = i / 255;
            target = target % 3;
            switch (target)
            {
                case 0:
                    r = i % 255;
                    b = 255 - r;
                    break;
                case 1:
                    g = i % 255;
                    r = 255 - g;
                    break;
                case 2:
                    b = i % 255;
                    g = 255 - b;
                    break;
            }
            return new Frame(new Color(r, g, b));
        }
        public static Frame RGBWave(Frame f)
        {
            Color[,] rtrn = new Color[32, 32];
            for (int j = 0; j < 32; j++)
            {
                int r = 0, g = 0, b = 0;
                int i = (Program.GetFrameCount() + j) * 17;
                int target = i / 255;
                target = target % 3;
                switch (target)
                {
                    case 0:
                        r = i % 255;
                        b = 255 - r;
                        break;
                    case 1:
                        g = i % 255;
                        r = 255 - g;
                        break;
                    case 2:
                        b = i % 255;
                        g = 255 - b;
                        break;
                }
                for (int k = 0; k < 32; k++)
                {
                    rtrn[j, k] = new Color(r, g, b);
                }
            }
            return new Frame(rtrn);
        }
    }
}