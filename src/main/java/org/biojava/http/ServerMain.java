/*
 *                    BioJava development code
 *
 * This code may be freely distributed and modified under the
 * terms of the GNU Lesser General Public Licence.  This should
 * be distributed with the code.  If you do not have a copy,
 * see:
 *
 *      http://www.gnu.org/copyleft/lesser.html
 *
 * Copyright for this code is held jointly by the individual
 * authors.  These should be listed in @author doc comments.
 *
 * For more information on the BioJava project and its aims,
 * or to join the biojava-l mailing list, visit the home page
 * at:
 *
 *      http://www.biojava.org/
 *
 * Created on Jul 6, 2016
 * Author: blivens 
 *
 */

package org.biojava.http;

import static spark.Spark.*;

import org.biojava.http.routes.MMCIFRoute;
import org.biojava.http.routes.NGLRoute;
import org.biojava.http.routes.PDBRoute;

import spark.template.handlebars.HandlebarsTemplateEngine;

public class ServerMain {
	public static void main(String[] args) {
		//  port(4567);
		
		get("/", (r,r2) -> "BioJava HTTP");

		get(BioJavaRoutes.PDB, new PDBRoute());

		get(BioJavaRoutes.MMCIF, new MMCIFRoute());

		get(BioJavaRoutes.NGL, new NGLRoute(), new HandlebarsTemplateEngine());
	}
}
