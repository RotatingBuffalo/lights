using System.Net.WebSockets;
using System.Net.Http;
using System.Diagnostics;
using lights.src.Graphics;
using System.Net;
using System.Net.Sockets;
namespace lights.src
{
    class Server
    {
        private int port = 12000;
        IPHostEntry host = Dns.GetHostEntry("localhost");
        IPAddress ipAddress;
        IPEndPoint ip;
        private Socket sock;
        private Frame f = new Frame();
        Algo.Algorithm currentAlgorithm;
        public Server()
        {
            ipAddress = host.AddressList[0];
            ip = new IPEndPoint(ipAddress, port);
            sock = new Socket(ipAddress.AddressFamily, SocketType.Stream, ProtocolType.Tcp);
            currentAlgorithm = Algo.HueFade;
        }
        ~Server()
        {
            Close();
        }
        public void Connect()
        {
            sock.Connect(ip);
        }
        public void SetAlgorithm(Algo.Algorithm a)
        {
            currentAlgorithm = a;
            Program.ResetCounter();
        }
        public void Reset()
        {
            sock.Disconnect(true);
            IPHostEntry host = Dns.GetHostEntry("localhost");
            IPAddress ipAddress = host.AddressList[0];
            IPEndPoint ip = new IPEndPoint(ipAddress, port);
            sock = new Socket(ipAddress.AddressFamily, SocketType.Stream, ProtocolType.Tcp);
            currentAlgorithm = Algo.HueFade;
        }
        public void Close()
        {
            sock.Send(System.Text.Encoding.ASCII.GetBytes(",\n"));
            sock.Shutdown(SocketShutdown.Both);
            sock.Close();
        }
        public void Run(int seconds)
        {
            Stopwatch s = new Stopwatch();
            s.Start();
            while (s.ElapsedMilliseconds < seconds * 1000)
            {
                f = currentAlgorithm(f);
                // This line is a bit of a doozy, but it just sends the frame data as a stream of ASCII encoded bytes.
                sock.Send(System.Text.Encoding.ASCII.GetBytes(f.ToString()));
                Program.IncrementCounter();
                // This should sleep for a 20th of a second, enabling a 20fps stream of frames.
                // I know there's better ways to do this, but eh.
                Thread.Sleep(1000 / 20);
            }
        }
    }
}