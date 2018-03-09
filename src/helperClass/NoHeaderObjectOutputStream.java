/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helperClass;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 *
 * @author LuNeR
 */
public class NoHeaderObjectOutputStream extends ObjectOutputStream {

    public NoHeaderObjectOutputStream(FileOutputStream os) throws IOException {
        super(os);
    }

    @Override
    protected void writeStreamHeader() {
    }

}
