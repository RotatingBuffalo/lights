using System;
namespace lights.src
{
    class Frame
    {
        private Color[,] pixels = new Color[32, 32];
        public override string ToString()
        {
            string rtrn = "";
            foreach (Color pixel in pixels)
            {
                rtrn += pixel.ToString();
            }
            return "{" + rtrn + "}\n";
        }
        public Frame(Color[,] pArray)
        {
            pixels = pArray;

        }
        public Frame(Color singleColor)
        {
            for (int k = 0; k < 32; k++)
            {
                for (int j = 0; j < 32; j++)
                {
                    pixels[k, j] = singleColor;
                }
            }
        }
        /*
        Default Constructor. This will flashbang you.
        Be very careful.    
        */
        public Frame()
        {
            pixels.Initialize();
        }

    }
}