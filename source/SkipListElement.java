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

    public SkipListElement(int pContent)
    {
        iContent=pContent;
    }

    public int getContent()
    {
        return iContent;
    }


    public SkipList chainElementIntoList(SkipList pList, SkipListElement pNewElement, SkipListElement[] pParentNodes)
    {
        if (pList.getHead().iNextElements.length < MAX_HEIGHT)
        {
            SkipListElement[] tElement = pList.getHead().iNextElements.clone();
            pList.getHead().iNextElements = new SkipListElement[MAX_HEIGHT];
            System.arraycopy(tElement, 0, pList.getHead().iNextElements, 0, tElement.length);
        }

        for (int tLevel = 0; tLevel < pNewElement.getHeight(); tLevel ++)
        {
            if (tLevel < iHeight)
            {
                SkipListElement tNextNode = iNextElements[tLevel];
                iNextElements[tLevel] = pNewElement;
                pNewElement.iNextElements[tLevel] = tNextNode;
            }
            else
            {
                SkipListElement tNextNode = pParentNodes[tLevel].iNextElements[tLevel];
                pParentNodes[tLevel].iNextElements[tLevel] = pNewElement;
                pNewElement.iNextElements[tLevel] = tNextNode;
            }
        }

        return pList;
    }

    public SkipListElement getNextElement(int pHeight)
    {
        if(iNextElements.length>pHeight)
        {
            return null;
        }
        return iNextElements[pHeight - 1];
    }

    public void setHeight(int pNewHeight)
    {
        iHeight=pNewHeight;
        iNextElements= new SkipListElement[pNewHeight];

        if(MAX_HEIGHT < pNewHeight)
        {
            MAX_HEIGHT = pNewHeight;
        }
    }

    public int getHeight()
    {
        return iHeight;
    }

}
