package com.mycompany.myapp.analyse.main;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.mycompany.myapp.analyse.babelTools.BabelSynsets;
import com.mycompany.myapp.analyse.dataTools.MapTools;
import com.mycompany.myapp.analyse.dataTools.TextTools;
import com.mycompany.myapp.analyse.dataTools.TokenGenerator;
import com.mycompany.myapp.analyse.metaClass.Definition;
import it.uniroma1.lcl.babelnet.BabelNet;

/**
 * Nouvelle ponderation en cours
 *
 * @author Vidal
 *
 */

public class runAnalyse {

	static BabelSynsets babelSynsets;

	public void runAnalyse() throws IOException {

			BabelNet bn = BabelNet.getInstance();

			String theTxt = "Les ordinateurs ont des GPU des CPU ainsi que des périphériques "; //Le texte a analyser, phrase possible, mais moyen tant que textTools n'a pas corriger la section avec ecrit //PARTIE A CORRIGER ITERATOR
			List<String> wordList = TextTools.textSpliter(theTxt); //On le decoupe
			System.out.println("TEXTE SPLITE" + wordList + "TEXTE SPLITE");

			List<List<Definition>> listOfSynset = BabelSynsets.synsetCreator(bn, wordList); //On recupere une list des synset des mots importants
			System.out.println("LISTE OF SYNSET " + listOfSynset +"LISTE OF SYNSET");

			//On recupere une list listant les valeurs de chaque elements definissant chaque mot du texte.
			System.out.println("GENERATION DE TOKEN");
			List<LinkedHashMap<String, Integer>> listOfHasMap = TokenGenerator.tokeningList(listOfSynset);
			System.out.println(listOfHasMap);

					Map<String, Integer> linkedMap = MapTools.fusion(listOfHasMap);
			System.out.println(MapTools.sortByValues(MapTools.fusion(listOfHasMap)));
			System.out.println("FINAL : " + MapTools.reduction(linkedMap));
		}

	}
