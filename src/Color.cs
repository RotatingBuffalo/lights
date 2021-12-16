using System.Globalization;
namespace lights.src
{
    public class Color
    {
        private int r;
        private int g;
        private int b;
        public Color(int r, int g, int b)
        {
            this.r = r;
            this.g = g;
            this.b = b;
        }
        public Color(string hex)
        {
            r = int.Parse(hex.Substring(0, 2), NumberStyles.HexNumber);
            g = int.Parse(hex.Substring(2, 2), NumberStyles.HexNumber);
            b = int.Parse(hex.Substring(4, 2), NumberStyles.HexNumber);
        }
        public Color()
        {
            r = 255;
            g = 255;
            b = 255;
        }
        public override string ToString()
        {
            return "#" + r.ToString("X2") + g.ToString("X2") + b.ToString("X2") + ";";
        }
    }
}