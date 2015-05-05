/*
/  SkipList
/  Created by : Orion
/  Created on : 5-5-2015
*/

public class SkipList
{
    private SkipListElement iHead;

    public SkipList()
    {
        iHead= new SkipListElement(null);
    }

    public SkipListElement getHead()
    {
        return iHead;
    }

    public SkipListElement search(Integer pContent)
    {
        return search(iHead, pContent, null, iHead.getHeight());
    }

    public SkipListElement search(SkipListElement pSleStart, Integer pContent, SkipListElement pSleEnde, int pLevel)
    {
        SkipListElement tPreviousElement = pSleStart;
        SkipListElement tCurrentElement = pSleStart;

        while((tCurrentElement.getContent() <= pContent) && (tCurrentElement != pSleEnde))
        {
            tPreviousElement = tCurrentElement;
            tCurrentElement = tCurrentElement.getNextElement(pLevel);
        }

        if(tPreviousElement.getContent()==pContent)
        {
            return tPreviousElement;
        }

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
        SkipListElement tNewElement= new SkipListElement(pContent);

        while(flipCoin())
        {
            tNewElement.setHeight(tNewElement.getHeight() + 1);
        }

        insert(iHead, tNewElement, null, iHead.getHeight(), new SkipListElement[iHead.getHeight()]);
    }

    public void insert(SkipListElement pSleStart, SkipListElement pSleToInsert, SkipListElement pSleEnde, int pLevel, SkipListElement[] pParentArray)
    {
        SkipListElement tPreviousElement = pSleStart;
        SkipListElement tCurrentElement = pSleStart;

        while((tCurrentElement.getContent() <= pSleToInsert.getContent()) && (tCurrentElement != pSleEnde))
        {
            tPreviousElement = tCurrentElement;
            tCurrentElement = tCurrentElement.getNextElement(pLevel);
        }

        if (tPreviousElement.getContent() == pSleToInsert.getContent())
        {
            tPreviousElement.chainElementIntoList(this, pSleToInsert, pParentArray);
            return;
        }

        if (tCurrentElement.getContent() == pSleToInsert.getContent())
        {
            tCurrentElement.chainElementIntoList(this, pSleToInsert, pParentArray);
            return;
        }

        if (pLevel > 1)
        {
            if ((tPreviousElement.getContent() < pSleToInsert.getContent()) && (tCurrentElement.getContent() > pSleToInsert.getContent()))
            {
                pParentArray[pLevel]=tPreviousElement;
                insert(tPreviousElement, pSleToInsert, tCurrentElement, pLevel - 1, pParentArray);
                return;
            }
        }

        tPreviousElement.chainElementIntoList(this, pSleToInsert, pParentArray);
    }
}
