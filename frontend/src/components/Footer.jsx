import React from "react";

export const Footer = () => {
  return (
    <footer
      style={{
        backgroundColor: "#222",
        color: "white",
        padding: "20px 40px",
        display: "flex",
        justifyContent: "space-between", 
        alignItems: "center",
        position: "relative",
        bottom: 0,
        width: "100%",
        marginTop: "auto", 
      }}
    >
      {/* Sobre Nosotros 1 */}
      <div>
        <h4>About Us</h4>
        <p style={{ maxWidth: "250px" }}>
          TamaTerapias 🌿 — bienestar, salud y equilibrio.
        </p>
      </div>

      {/* RRSS (IG, Facebook, Tiktok)*/}
      <div style={{display:"flex",flexDirection:"column", justifyContent:"space-between"}}>
        <h4>RRSS</h4>
        <a
            href="https://www.instagram.com/tamaterapias"
            target="_blank"
            rel="noopener noreferrer"
            style={{ color: "white", textDecoration: "none" }}
          >
            <i className="bi bi-instagram"></i> Instagram
          </a>
        <a
            href="https://www.facebook.com/tamaterapias"
            target="_blank"
            rel="noopener noreferrer"
            style={{ color: "white", textDecoration: "none" }}>
            <i className="bi bi-facebook"></i> Facebook
        </a>

        <a
            href="https://www.tiktok.com/@tamaterapias"
            target="_blank"
            rel="noopener noreferrer"
            style={{ color: "white", textDecoration: "none" }}
          >
            <i className="bi bi-tiktok"></i> TikTok
          </a>

      </div>

      {/* Contacto */}
      <div>
        <h4>Contacto</h4>
        <p>📞 +34 600 123 456</p>
        <p>📧 info@tamaterapias.com</p>
      </div>
    </footer>
  );
};
