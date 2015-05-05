/*
/  SkipList
/  Created by : Orion
/  Created on : 5-5-2015
*/

public class SkipList
{
    private SkipListElement iHead;

    public SkipListElement getHead()
    {
        return iHead;
    }

    public SkipListElement search(int pContent)
    {
        return search(iHead, pContent, null, iHead.getHeight());
    }

    public SkipListElement search(SkipListElement pSleStart, int pContent, SkipListElement pSleEnde, int pLevel)
    {
        SkipListElement tPreviousElement = pSleStart;
        SkipListElement tCurrentElement = pSleStart;

        while((tCurrentElement.getContent() <= pContent) && (tCurrentElement != pSleEnde))
        {
            tPreviousElement = tCurrentElement;
            tCurrentElement = tCurrentElement.getNextElement(pLevel);
        }

        //TODO: Implement element checking.

        if (pLevel > 1)
        {
            if ((tPreviousElement.getContent() < pContent) && (tCurrentElement.getContent() > pContent))
            {
                return search(tPreviousElement, pContent, tCurrentElement, pLevel - 1);
            }
        }

        return null;
    }

    public void insert(int pContent)
    {
        SkipListElement tNewElement= new SkipListElement();

        while(flipCoin())
        {
            tNewElement.setHeight(tNewElement.getHeight() + 1);
        }


    }

    public void insert ()
}
