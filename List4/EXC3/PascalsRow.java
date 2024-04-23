import java.util.ArrayList;
import java.util.logging.Level;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PascalsRow
{
    private int n;

    public PascalsRow(final int n) throws IllegalArgumentException
    {
        if(n < 0)
        {
            throw new IllegalArgumentException("n should be >= 0, got " + n);
        }
        this.n = n;
    }

    public long Element(final int m) throws IllegalArgumentException
    {
        if(m < 0 || m > n)
        {
            throw new IllegalArgumentException("m should be 0 <= m <= " + n + ", got " + m);
        }
        return Math.NewtonSymbol(n, m);
    }

    public ArrayList<Long> Row()
    {
        ArrayList<Long> result = new ArrayList<Long>(0);
        try
        {
            for (int i = 0; i <= n; i++) 
            {
                Process process = execute(n, i);

                BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
                String output = reader.readLine();
                Long element = Long.parseLong(output);
                result.add(element);
            }
        }
        catch (IOException e)
        {
            AppLogger.logger.log(Level.SEVERE, "C++ reading exception: ", e);
        }
        
        return result;
    }

    private Process execute(int row, int element) throws IOException 
    {
        String[] command = {"./BIN/app.exe", Integer.toString(row), Integer.toString(element)};

        ProcessBuilder processBuilder = new ProcessBuilder(command);
        return processBuilder.start();
    }
}