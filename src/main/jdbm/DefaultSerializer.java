/*******************************************************************************
 * Copyright 2010 Cees De Groot, Alex Boisvert, Jan Kotek
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ******************************************************************************/

package jdbm;


import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * Default java serializer. Constructor is privite, use  DefaultSerializer.INSTANCE
 *
 * @author <a href="mailto:boisvert@intalio.com">Alex Boisvert</a>
 */
public class DefaultSerializer
    implements Serializer<Object>
{

	private static final long serialVersionUID = -3818545055661017388L;
	
	public static final DefaultSerializer INSTANCE = new DefaultSerializer();
    
    
    /**
     * Construct a DefaultSerializer, is private to make sure every one uses INSTANCE
     */
    private DefaultSerializer()
    {
        // no op
    }


     public void serialize(ObjectOutput out,Object obj)
        throws IOException
     {    
    	 out.writeObject(obj);        
     }
        

     public Object deserialize(ObjectInput in )
        throws IOException
     {
         try {
            return in.readObject();
         } catch ( ClassNotFoundException except ) {
            throw new IOException( except );
         }
     }

}
