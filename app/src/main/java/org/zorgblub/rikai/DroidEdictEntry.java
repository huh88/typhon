package org.zorgblub.rikai;

import android.graphics.Color;
import android.text.Html;
import android.text.Spanned;

import org.rikai.deinflector.DeinflectedWord;
import org.rikai.dictionary.edict.EdictEntry;

import static org.zorgblub.rikai.HtmlEntryUtils.wrapColor;

/**
 * Created by Benjamin on 16/09/2015.
 */
public class DroidEdictEntry extends EdictEntry implements DroidEntry {
    // default value are set to the rikaichan style
    private int kanjiColor = -1;

    private int kanaColor = -1;

    private int definitionColor = -1;

    private int reasonColor = -1;


    public DroidEdictEntry() {
    }

    public DroidEdictEntry(DeinflectedWord variant, String word, String reading, String gloss, String reason) {
        super(variant, word, reading, gloss, reason);
    }

    public DroidEdictEntry(String msg){
        super(new DeinflectedWord(msg), msg, "", "", "");
    }

    public int getKanjiColor() {
        return kanjiColor;
    }

    public void setKanjiColor(int kanjiColor) {
        this.kanjiColor = kanjiColor;
    }

    public int getKanaColor() {
        return kanaColor;
    }

    public int getReasonColor() {
        return reasonColor;
    }

    public int getDefinitionColor() {
        return definitionColor;
    }

    public void setDefinitionColor(int definitionColor) {
        this.definitionColor = definitionColor;
    }

    public void setKanaColor(int kanaColor) {
        this.kanaColor = kanaColor;
    }

    public void setReasonColor(int reasonColor) {
        this.reasonColor = reasonColor;
    }

    @Override
    public int getBackgroundColor() {
        return Color.WHITE;
    }

    @Override
    public String toStringCompact() {
        StringBuilder result = new StringBuilder(this.getLength());

        //result.append(wrapColor(Color.BLACK, this.getWord()));
        result.append(this.getWord());

        if (this.getReading().length() != 0) {
            //result.append(" [").append(wrapColor(Color.BLACK, this.getReading())).append("]");
            result.append(" [").append(this.getReading()).append("]");
        }
        if (this.getReason().length() != 0) {
            //result.append(" (").append(wrapColor(Color.BLACK, this.getReason())).append(")");
            result.append(" (").append(this.getReason()).append(")");
        }

        //result.append("<br/>").append(wrapColor(Color.BLACK, this.getGloss()));
        result.append("<br/>").append(this.getGloss());

        return result.toString();
    }

    @Override
    public Spanned render() {
        return Html.fromHtml(this.toStringCompact());
    }
}
