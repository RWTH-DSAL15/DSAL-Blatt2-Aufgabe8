/*
/  SkipListElement
/  Created by : Orion
/  Created on : 5-5-2015
*/

public class SkipListElement {

    private static int MAX_HEIGHT = 2;

    private int iHeight = 1;
    private SkipListElement[] iNextElements = new SkipListElement[MAX_HEIGHT];

    private int iContent = -1;

    public SkipListElement()
    {

    }

    public SkipListElement chainElementIntoList(SkipListElement tNewElement)
    {
        return tNewElement;
    }

    public void setHeight(int pNewHeight)
    {

    }
}
